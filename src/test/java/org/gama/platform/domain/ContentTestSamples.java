package org.gama.platform.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ContentTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Content getContentSample1() {
        return new Content().id(1L).name("name1").description("description1");
    }

    public static Content getContentSample2() {
        return new Content().id(2L).name("name2").description("description2");
    }

    public static Content getContentRandomSampleGenerator() {
        return new Content().id(longCount.incrementAndGet()).name(UUID.randomUUID().toString()).description(UUID.randomUUID().toString());
    }
}
