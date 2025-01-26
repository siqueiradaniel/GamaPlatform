package org.gama.platform.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class DependencyTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Dependency getDependencySample1() {
        return new Dependency().id(1L);
    }

    public static Dependency getDependencySample2() {
        return new Dependency().id(2L);
    }

    public static Dependency getDependencyRandomSampleGenerator() {
        return new Dependency().id(longCount.incrementAndGet());
    }
}
