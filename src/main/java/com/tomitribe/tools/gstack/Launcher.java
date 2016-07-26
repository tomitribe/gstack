package com.tomitribe.tools.gstack;

import lombok.RequiredArgsConstructor;
import org.tomitribe.crest.Main;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.asList;
import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public class Launcher {
    public static void main(final String[] args) throws Exception {
        final Collection<String> newArgs = new ArrayList<>();
        newArgs.add("gstack");
        newArgs.add("analize");
        if (args != null) {
            newArgs.addAll(asList(args));
        }
        Main.main(newArgs.toArray(new String[newArgs.size()]));
    }
}
