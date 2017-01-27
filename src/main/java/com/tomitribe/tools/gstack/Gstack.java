package com.tomitribe.tools.gstack;

import lombok.RequiredArgsConstructor;
import org.tomitribe.crest.api.Command;
import org.tomitribe.crest.api.Default;
import org.tomitribe.crest.api.In;
import org.tomitribe.crest.api.Option;
import org.tomitribe.crest.api.Out;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
@Command("gstack")
public class Gstack {
    @Command("analize")
    public static void analize(@Option("buffer-size") @Default("256") final int bufferSize,
                               @Option("use-contains") @Default("true") final boolean useContain,
                               @In final InputStream in,
                               @Out final PrintStream out,
                               @Option("include") final String[] include,
                               @Option("exclude") final String[] exclude,
                               @Option("file") final String[] files) throws IOException {
        final Pattern[] includes = include == null || include.length == 0 ?
                new Pattern[]{Pattern.compile(".*")} : ofNullable(include).map(i -> Stream.of(i)
                .map(f -> useContain ? ".*" + f + ".*" : f)
                .map(Pattern::compile)
                .toArray(Pattern[]::new)).orElse(null);
        final Pattern[] excludes = exclude == null || exclude.length == 0 ?
                new Pattern[0] : ofNullable(exclude).map(e -> Stream.of(e)
                .map(f -> useContain ? ".*" + f + ".*" : f)
                .map(Pattern::compile)
                .toArray(Pattern[]::new)).orElse(null);

        if (files == null || files.length == 0) {
            execute(in, out, bufferSize, includes, excludes);
        } else {
            Stream.of(files).forEach(f -> {
                try (final InputStream is = new FileInputStream(f)) {
                    execute(is, out, bufferSize, includes, excludes);
                } catch (final IOException e) {
                    throw new IllegalStateException(e);
                }
            });
        }
    }

    private static void execute(final InputStream in, final PrintStream out,
                                final int bufferSize, final Pattern[] includes, final Pattern[] excludes) throws IOException {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(in) {
            @Override
            public void close() throws IOException {
                // no-op: stdin shouldn't be closed
            }
        }, bufferSize)) {
            String threadLine;
            while ((threadLine = reader.readLine()) != null && !threadLine.startsWith("\"")) {
                // read one more
            }
            if (threadLine == null) {
                return;
            }

            String stackLine;
            final StringBuilder builder = new StringBuilder();
            while ((stackLine = reader.readLine()) != null) {
                if (stackLine.trim().isEmpty()) {
                    continue;
                }

                if (stackLine.startsWith("\"")) { // thread name
                    final String thread = threadLine;
                    of(builder).filter(b -> b.length() > 0).ifPresent(b -> {
                        out.println(thread);
                        out.print(b);
                    });
                    builder.setLength(0);
                    threadLine = stackLine;
                } else {
                    of(stackLine).filter(c ->
                            (includes == null || includes.length == 0 || Stream.of(includes).anyMatch(p -> p.matcher(c).matches())) &&
                                    (excludes == null || excludes.length == 0 || Stream.of(excludes).noneMatch(p -> p.matcher(c).matches())))
                            .ifPresent(c -> builder.append(c).append(lineSeparator()));
                }
            }
        }
    }
}
