package com.javase.Conncurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class AllThread {
    public static void main(String[] args) {
        ThreadMXBean tmb = ManagementFactory.getThreadMXBean();
        ThreadInfo[] infos = tmb.dumpAllThreads(false,false);
        for (ThreadInfo ti:
             infos) {
            System.out.println(ti.getThreadId()+ti.getThreadName());
        }
    }
}
