package org.gama.platform.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LearningPathTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static LearningPath getLearningPathSample1() {
        return new LearningPath().id(1L).order(1);
    }

    public static LearningPath getLearningPathSample2() {
        return new LearningPath().id(2L).order(2);
    }

    public static LearningPath getLearningPathRandomSampleGenerator() {
        return new LearningPath().id(longCount.incrementAndGet()).order(intCount.incrementAndGet());
    }
}
