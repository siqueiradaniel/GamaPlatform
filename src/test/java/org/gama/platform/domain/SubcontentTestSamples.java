package org.gama.platform.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class SubcontentTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Subcontent getSubcontentSample1() {
        return new Subcontent().id(1L).name("name1").description("description1");
    }

    public static Subcontent getSubcontentSample2() {
        return new Subcontent().id(2L).name("name2").description("description2");
    }

    public static Subcontent getSubcontentRandomSampleGenerator() {
        return new Subcontent()
            .id(longCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString());
    }
}
