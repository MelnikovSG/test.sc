package com.test.sc.assistants;

public class ServiceCounter {
    private static final int MAX_SERVICES = 10000;
    private static volatile int currentServices = 0;

    public synchronized static boolean canAddService() {
        if (currentServices >= MAX_SERVICES) {
            return false;
        }else {
            currentServices++;
            return true;
        }
    }

    public synchronized static void removeService() {
        currentServices--;
    }
}
