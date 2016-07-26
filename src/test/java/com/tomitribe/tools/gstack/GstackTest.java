package com.tomitribe.tools.gstack;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class GstackTest {
    @Test
    public void analize() throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        Gstack.analize(
                256, true,
                new ByteArrayInputStream(("\n" +
                        "2016-07-26 10:37:00\n" +
                        "Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.25-b02 mixed mode):\n" +
                        "\n" +
                        "\"Attach Listener\" #12 daemon prio=9 os_prio=0 tid=0x00007f78c8001000 nid=0xbf6 waiting on condition [0x0000000000000000]\n" +
                        "   java.lang.Thread.State: RUNNABLE\n" +
                        "\n" +
                        "\"GC Daemon\" #11 daemon prio=2 os_prio=0 tid=0x00007f7910f6c800 nid=0xbe6 in Object.wait() [0x00007f78f993b000]\n" +
                        "   java.lang.Thread.State: TIMED_WAITING (on object monitor)\n" +
                        "        at java.lang.Object.wait(Native Method)\n" +
                        "        - waiting on <0x00000007722c1880> (a sun.misc.GC$LatencyLock)\n" +
                        "        at sun.misc.GC$Daemon.run(GC.java:117)\n" +
                        "        - locked <0x00000007722c1880> (a sun.misc.GC$LatencyLock)\n" +
                        "\n" +
                        "\"Service Thread\" #10 daemon prio=9 os_prio=0 tid=0x00007f79102cf000 nid=0xbe4 runnable [0x0000000000000000]\n" +
                        "   java.lang.Thread.State: RUNNABLE\n" +
                        "\n" +
                        "\"C1 CompilerThread2\" #9 daemon prio=9 os_prio=0 tid=0x00007f79102ba000 nid=0xbe3 waiting on condition [0x0000000000000000]\n" +
                        "   java.lang.Thread.State: RUNNABLE\n" +
                        "\n" +
                        "\"C2 CompilerThread1\" #8 daemon prio=9 os_prio=0 tid=0x00007f79102c3000 nid=0xbe2 waiting on condition [0x0000000000000000]\n" +
                        "   java.lang.Thread.State: RUNNABLE\n" +
                        "\n" +
                        "\"C2 CompilerThread0\" #7 daemon prio=9 os_prio=0 tid=0x00007f7910332800 nid=0xbe1 waiting on condition [0x0000000000000000]\n" +
                        "   java.lang.Thread.State: RUNNABLE\n" +
                        "\n" +
                        "\"Signal Dispatcher\" #4 daemon prio=9 os_prio=0 tid=0x00007f7910173000 nid=0xbd1 runnable [0x0000000000000000]\n" +
                        "   java.lang.Thread.State: RUNNABLE\n" +
                        "\n" +
                        "\"Finalizer\" #3 daemon prio=8 os_prio=0 tid=0x00007f7910146000 nid=0xbd0 in Object.wait() [0x00007f78faeed000]\n" +
                        "   java.lang.Thread.State: WAITING (on object monitor)\n" +
                        "        at java.lang.Object.wait(Native Method)\n" +
                        "        - waiting on <0x000000076ab06280> (a java.lang.ref.ReferenceQueue$Lock)\n" +
                        "        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:142)\n" +
                        "        - locked <0x000000076ab06280> (a java.lang.ref.ReferenceQueue$Lock)\n" +
                        "        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:158)\n" +
                        "        at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)\n" +
                        "\n" +
                        "\"Reference Handler\" #2 daemon prio=10 os_prio=0 tid=0x00007f7910143800 nid=0xbcf in Object.wait() [0x00007f78fafee000]\n" +
                        "   java.lang.Thread.State: WAITING (on object monitor)\n" +
                        "        at java.lang.Object.wait(Native Method)\n" +
                        "        - waiting on <0x000000076ab05cf0> (a java.lang.ref.Reference$Lock)\n" +
                        "        at java.lang.Object.wait(Object.java:502)\n" +
                        "        at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:157)\n" +
                        "        - locked <0x000000076ab05cf0> (a java.lang.ref.Reference$Lock)\n" +
                        "\n" +
                        "\"main\" #1 prio=5 os_prio=0 tid=0x00007f791000b000 nid=0xbc9 runnable [0x00007f79183b8000]\n" +
                        "   java.lang.Thread.State: RUNNABLE\n" +
                        "        at sun.security.provider.X509Factory.engineGenerateCertificate(X509Factory.java:99)\n" +
                        "        at java.security.cert.CertificateFactory.generateCertificate(CertificateFactory.java:339)\n" +
                        "        at sun.security.pkcs.PKCS7.parseSignedData(PKCS7.java:329)\n" +
                        "        at sun.security.pkcs.PKCS7.parse(PKCS7.java:186)\n" +
                        "        at sun.security.pkcs.PKCS7.parse(PKCS7.java:154)\n" +
                        "        at sun.security.pkcs.PKCS7.<init>(PKCS7.java:136)\n" +
                        "        at sun.security.util.SignatureFileVerifier.<init>(SignatureFileVerifier.java:95)\n" +
                        "        at java.util.jar.JarVerifier.processEntry(JarVerifier.java:297)\n" +
                        "        at java.util.jar.JarVerifier.update(JarVerifier.java:228)\n" +
                        "        at java.util.jar.JarFile.initializeVerifier(JarFile.java:383)\n" +
                        "        at java.util.jar.JarFile.getInputStream(JarFile.java:450)\n" +
                        "        - locked <0x00000007722de8c0> (a java.util.jar.JarFile)\n" +
                        "        at sun.misc.URLClassPath$JarLoader$2.getInputStream(URLClassPath.java:776)\n" +
                        "        at sun.misc.Resource.cachedInputStream(Resource.java:77)\n" +
                        "        - locked <0x000000077232b2e0> (a sun.misc.URLClassPath$JarLoader$2)\n" +
                        "        at sun.misc.Resource.getByteBuffer(Resource.java:160)\n" +
                        "        at java.net.URLClassLoader.defineClass(URLClassLoader.java:442)\n" +
                        "        at java.net.URLClassLoader.access$100(URLClassLoader.java:73)\n" +
                        "        at java.net.URLClassLoader$1.run(URLClassLoader.java:367)\n" +
                        "        at java.net.URLClassLoader$1.run(URLClassLoader.java:361)\n" +
                        "        at java.security.AccessController.doPrivileged(Native Method)\n" +
                        "        at java.net.URLClassLoader.findClass(URLClassLoader.java:360)\n" +
                        "        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)\n" +
                        "        - locked <0x000000077232a5f0> (a java.lang.Object)\n" +
                        "        at java.lang.ClassLoader.loadClass(ClassLoader.java:411)\n" +
                        "        - locked <0x000000077232a568> (a java.lang.Object)\n" +
                        "        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:308)\n" +
                        "        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)\n" +
                        "        at sun.security.jca.ProviderConfig$2.run(ProviderConfig.java:215)\n" +
                        "        at sun.security.jca.ProviderConfig$2.run(ProviderConfig.java:206)\n" +
                        "        at java.security.AccessController.doPrivileged(Native Method)\n" +
                        "        at sun.security.jca.ProviderConfig.doLoadProvider(ProviderConfig.java:206)\n" +
                        "        at sun.security.jca.ProviderConfig.getProvider(ProviderConfig.java:187)\n" +
                        "        - locked <0x0000000772306160> (a sun.security.jca.ProviderConfig)\n" +
                        "        at sun.security.jca.ProviderList.loadAll(ProviderList.java:282)\n" +
                        "        at sun.security.jca.ProviderList.removeInvalid(ProviderList.java:299)\n" +
                        "        at sun.security.jca.Providers.getFullProviderList(Providers.java:173)\n" +
                        "        at java.security.Security.getProviders(Security.java:452)\n" +
                        "        at org.apache.catalina.core.JreMemoryLeakPreventionListener.lifecycleEvent(JreMemoryLeakPreventionListener.java:410)\n" +
                        "        at org.apache.catalina.util.LifecycleSupport.fireLifecycleEvent(LifecycleSupport.java:117)\n" +
                        "        at org.apache.catalina.util.LifecycleBase.fireLifecycleEvent(LifecycleBase.java:90)\n" +
                        "        at org.apache.catalina.util.LifecycleBase.setStateInternal(LifecycleBase.java:394)\n" +
                        "        - locked <0x000000076f556998> (a org.apache.catalina.core.StandardServer)\n" +
                        "        at org.apache.catalina.util.LifecycleBase.init(LifecycleBase.java:99)\n" +
                        "        - locked <0x000000076f556998> (a org.apache.catalina.core.StandardServer)\n" +
                        "        at org.apache.catalina.startup.Catalina.load(Catalina.java:642)\n" +
                        "        at org.apache.catalina.startup.Catalina.load(Catalina.java:667)\n" +
                        "        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
                        "        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n" +
                        "        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                        "        at java.lang.reflect.Method.invoke(Method.java:483)\n" +
                        "        at org.apache.catalina.startup.Bootstrap.load(Bootstrap.java:253)\n" +
                        "        at org.apache.catalina.startup.Bootstrap.main(Bootstrap.java:427)\n" +
                        "\n" +
                        "\"VM Thread\" os_prio=0 tid=0x00007f791013c800 nid=0xbce runnable\n" +
                        "\n" +
                        "\"GC task thread#0 (ParallelGC)\" os_prio=0 tid=0x00007f7910020800 nid=0xbca runnable\n" +
                        "\n" +
                        "\"GC task thread#1 (ParallelGC)\" os_prio=0 tid=0x00007f7910022000 nid=0xbcb runnable\n" +
                        "\n" +
                        "\"GC task thread#2 (ParallelGC)\" os_prio=0 tid=0x00007f7910024000 nid=0xbcc runnable\n" +
                        "\n" +
                        "\"GC task thread#3 (ParallelGC)\" os_prio=0 tid=0x00007f7910026000 nid=0xbcd runnable\n" +
                        "\n" +
                        "\"VM Periodic Task Thread\" os_prio=0 tid=0x00007f79102d1800 nid=0xbe5 waiting on condition\n" +
                        "\n" +
                        "JNI global references: 59\n").getBytes()), new PrintStream(out),
                new String[]{"catalina", "jar"}, null);
        assertEquals(
                "\"main\" #1 prio=5 os_prio=0 tid=0x00007f791000b000 nid=0xbc9 runnable [0x00007f79183b8000]\n" +
                        "        at java.util.jar.JarVerifier.processEntry(JarVerifier.java:297)\n" +
                        "        at java.util.jar.JarVerifier.update(JarVerifier.java:228)\n" +
                        "        at java.util.jar.JarFile.initializeVerifier(JarFile.java:383)\n" +
                        "        at java.util.jar.JarFile.getInputStream(JarFile.java:450)\n" +
                        "        - locked <0x00000007722de8c0> (a java.util.jar.JarFile)\n" +
                        "        at org.apache.catalina.core.JreMemoryLeakPreventionListener.lifecycleEvent(JreMemoryLeakPreventionListener.java:410)\n" +
                        "        at org.apache.catalina.util.LifecycleSupport.fireLifecycleEvent(LifecycleSupport.java:117)\n" +
                        "        at org.apache.catalina.util.LifecycleBase.fireLifecycleEvent(LifecycleBase.java:90)\n" +
                        "        at org.apache.catalina.util.LifecycleBase.setStateInternal(LifecycleBase.java:394)\n" +
                        "        - locked <0x000000076f556998> (a org.apache.catalina.core.StandardServer)\n" +
                        "        at org.apache.catalina.util.LifecycleBase.init(LifecycleBase.java:99)\n" +
                        "        - locked <0x000000076f556998> (a org.apache.catalina.core.StandardServer)\n" +
                        "        at org.apache.catalina.startup.Catalina.load(Catalina.java:642)\n" +
                        "        at org.apache.catalina.startup.Catalina.load(Catalina.java:667)\n" +
                        "        at org.apache.catalina.startup.Bootstrap.load(Bootstrap.java:253)\n" +
                        "        at org.apache.catalina.startup.Bootstrap.main(Bootstrap.java:427)\n",
                new String(out.toByteArray(), StandardCharsets.UTF_8).replace("\r", ""));
    }

    @Test
    public void run() throws Exception {
        System.setIn(new ByteArrayInputStream(("\n" +
                "2016-07-26 10:37:00\n" +
                "Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.25-b02 mixed mode):\n" +
                "\n" +
                "\"Attach Listener\" #12 daemon prio=9 os_prio=0 tid=0x00007f78c8001000 nid=0xbf6 waiting on condition [0x0000000000000000]\n" +
                "   java.lang.Thread.State: RUNNABLE\n" +
                "\n" +
                "\"GC Daemon\" #11 daemon prio=2 os_prio=0 tid=0x00007f7910f6c800 nid=0xbe6 in Object.wait() [0x00007f78f993b000]\n" +
                "   java.lang.Thread.State: TIMED_WAITING (on object monitor)\n" +
                "        at java.lang.Object.wait(Native Method)\n" +
                "        - waiting on <0x00000007722c1880> (a sun.misc.GC$LatencyLock)\n" +
                "        at sun.misc.GC$Daemon.run(GC.java:117)\n" +
                "        - locked <0x00000007722c1880> (a sun.misc.GC$LatencyLock)\n" +
                "\n" +
                "\"Service Thread\" #10 daemon prio=9 os_prio=0 tid=0x00007f79102cf000 nid=0xbe4 runnable [0x0000000000000000]\n" +
                "   java.lang.Thread.State: RUNNABLE\n" +
                "\n" +
                "\"C1 CompilerThread2\" #9 daemon prio=9 os_prio=0 tid=0x00007f79102ba000 nid=0xbe3 waiting on condition [0x0000000000000000]\n" +
                "   java.lang.Thread.State: RUNNABLE\n" +
                "\n" +
                "\"C2 CompilerThread1\" #8 daemon prio=9 os_prio=0 tid=0x00007f79102c3000 nid=0xbe2 waiting on condition [0x0000000000000000]\n" +
                "   java.lang.Thread.State: RUNNABLE\n" +
                "\n" +
                "\"C2 CompilerThread0\" #7 daemon prio=9 os_prio=0 tid=0x00007f7910332800 nid=0xbe1 waiting on condition [0x0000000000000000]\n" +
                "   java.lang.Thread.State: RUNNABLE\n" +
                "\n" +
                "\"Signal Dispatcher\" #4 daemon prio=9 os_prio=0 tid=0x00007f7910173000 nid=0xbd1 runnable [0x0000000000000000]\n" +
                "   java.lang.Thread.State: RUNNABLE\n" +
                "\n" +
                "\"Finalizer\" #3 daemon prio=8 os_prio=0 tid=0x00007f7910146000 nid=0xbd0 in Object.wait() [0x00007f78faeed000]\n" +
                "   java.lang.Thread.State: WAITING (on object monitor)\n" +
                "        at java.lang.Object.wait(Native Method)\n" +
                "        - waiting on <0x000000076ab06280> (a java.lang.ref.ReferenceQueue$Lock)\n" +
                "        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:142)\n" +
                "        - locked <0x000000076ab06280> (a java.lang.ref.ReferenceQueue$Lock)\n" +
                "        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:158)\n" +
                "        at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)\n" +
                "\n" +
                "\"Reference Handler\" #2 daemon prio=10 os_prio=0 tid=0x00007f7910143800 nid=0xbcf in Object.wait() [0x00007f78fafee000]\n" +
                "   java.lang.Thread.State: WAITING (on object monitor)\n" +
                "        at java.lang.Object.wait(Native Method)\n" +
                "        - waiting on <0x000000076ab05cf0> (a java.lang.ref.Reference$Lock)\n" +
                "        at java.lang.Object.wait(Object.java:502)\n" +
                "        at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:157)\n" +
                "        - locked <0x000000076ab05cf0> (a java.lang.ref.Reference$Lock)\n" +
                "\n" +
                "\"main\" #1 prio=5 os_prio=0 tid=0x00007f791000b000 nid=0xbc9 runnable [0x00007f79183b8000]\n" +
                "   java.lang.Thread.State: RUNNABLE\n" +
                "        at sun.security.provider.X509Factory.engineGenerateCertificate(X509Factory.java:99)\n" +
                "        at java.security.cert.CertificateFactory.generateCertificate(CertificateFactory.java:339)\n" +
                "        at sun.security.pkcs.PKCS7.parseSignedData(PKCS7.java:329)\n" +
                "        at sun.security.pkcs.PKCS7.parse(PKCS7.java:186)\n" +
                "        at sun.security.pkcs.PKCS7.parse(PKCS7.java:154)\n" +
                "        at sun.security.pkcs.PKCS7.<init>(PKCS7.java:136)\n" +
                "        at sun.security.util.SignatureFileVerifier.<init>(SignatureFileVerifier.java:95)\n" +
                "        at java.util.jar.JarVerifier.processEntry(JarVerifier.java:297)\n" +
                "        at java.util.jar.JarVerifier.update(JarVerifier.java:228)\n" +
                "        at java.util.jar.JarFile.initializeVerifier(JarFile.java:383)\n" +
                "        at java.util.jar.JarFile.getInputStream(JarFile.java:450)\n" +
                "        - locked <0x00000007722de8c0> (a java.util.jar.JarFile)\n" +
                "        at sun.misc.URLClassPath$JarLoader$2.getInputStream(URLClassPath.java:776)\n" +
                "        at sun.misc.Resource.cachedInputStream(Resource.java:77)\n" +
                "        - locked <0x000000077232b2e0> (a sun.misc.URLClassPath$JarLoader$2)\n" +
                "        at sun.misc.Resource.getByteBuffer(Resource.java:160)\n" +
                "        at java.net.URLClassLoader.defineClass(URLClassLoader.java:442)\n" +
                "        at java.net.URLClassLoader.access$100(URLClassLoader.java:73)\n" +
                "        at java.net.URLClassLoader$1.run(URLClassLoader.java:367)\n" +
                "        at java.net.URLClassLoader$1.run(URLClassLoader.java:361)\n" +
                "        at java.security.AccessController.doPrivileged(Native Method)\n" +
                "        at java.net.URLClassLoader.findClass(URLClassLoader.java:360)\n" +
                "        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)\n" +
                "        - locked <0x000000077232a5f0> (a java.lang.Object)\n" +
                "        at java.lang.ClassLoader.loadClass(ClassLoader.java:411)\n" +
                "        - locked <0x000000077232a568> (a java.lang.Object)\n" +
                "        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:308)\n" +
                "        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)\n" +
                "        at sun.security.jca.ProviderConfig$2.run(ProviderConfig.java:215)\n" +
                "        at sun.security.jca.ProviderConfig$2.run(ProviderConfig.java:206)\n" +
                "        at java.security.AccessController.doPrivileged(Native Method)\n" +
                "        at sun.security.jca.ProviderConfig.doLoadProvider(ProviderConfig.java:206)\n" +
                "        at sun.security.jca.ProviderConfig.getProvider(ProviderConfig.java:187)\n" +
                "        - locked <0x0000000772306160> (a sun.security.jca.ProviderConfig)\n" +
                "        at sun.security.jca.ProviderList.loadAll(ProviderList.java:282)\n" +
                "        at sun.security.jca.ProviderList.removeInvalid(ProviderList.java:299)\n" +
                "        at sun.security.jca.Providers.getFullProviderList(Providers.java:173)\n" +
                "        at java.security.Security.getProviders(Security.java:452)\n" +
                "        at org.apache.catalina.core.JreMemoryLeakPreventionListener.lifecycleEvent(JreMemoryLeakPreventionListener.java:410)\n" +
                "        at org.apache.catalina.util.LifecycleSupport.fireLifecycleEvent(LifecycleSupport.java:117)\n" +
                "        at org.apache.catalina.util.LifecycleBase.fireLifecycleEvent(LifecycleBase.java:90)\n" +
                "        at org.apache.catalina.util.LifecycleBase.setStateInternal(LifecycleBase.java:394)\n" +
                "        - locked <0x000000076f556998> (a org.apache.catalina.core.StandardServer)\n" +
                "        at org.apache.catalina.util.LifecycleBase.init(LifecycleBase.java:99)\n" +
                "        - locked <0x000000076f556998> (a org.apache.catalina.core.StandardServer)\n" +
                "        at org.apache.catalina.startup.Catalina.load(Catalina.java:642)\n" +
                "        at org.apache.catalina.startup.Catalina.load(Catalina.java:667)\n" +
                "        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
                "        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n" +
                "        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "        at java.lang.reflect.Method.invoke(Method.java:483)\n" +
                "        at org.apache.catalina.startup.Bootstrap.load(Bootstrap.java:253)\n" +
                "        at org.apache.catalina.startup.Bootstrap.main(Bootstrap.java:427)\n" +
                "\n" +
                "\"VM Thread\" os_prio=0 tid=0x00007f791013c800 nid=0xbce runnable\n" +
                "\n" +
                "\"GC task thread#0 (ParallelGC)\" os_prio=0 tid=0x00007f7910020800 nid=0xbca runnable\n" +
                "\n" +
                "\"GC task thread#1 (ParallelGC)\" os_prio=0 tid=0x00007f7910022000 nid=0xbcb runnable\n" +
                "\n" +
                "\"GC task thread#2 (ParallelGC)\" os_prio=0 tid=0x00007f7910024000 nid=0xbcc runnable\n" +
                "\n" +
                "\"GC task thread#3 (ParallelGC)\" os_prio=0 tid=0x00007f7910026000 nid=0xbcd runnable\n" +
                "\n" +
                "\"VM Periodic Task Thread\" os_prio=0 tid=0x00007f79102d1800 nid=0xbe5 waiting on condition\n" +
                "\n" +
                "JNI global references: 59\n").getBytes()));
        Launcher.main(new String[]{"--include=tomitribe"});
    }
}
