package Concurrency;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {
    // Lock-free synchronization with java.util.concurrent.atomic
    private static final AtomicLong nextSerialNum = new AtomicLong();
    public static long generateSerialNumber() {
        return nextSerialNum.getAndIncrement();
    }
}
