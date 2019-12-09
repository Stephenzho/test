package lock;

import lombok.Data;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class LockTest {

    private ExecutorService executors = Executors.newWorkStealingPool();



    @Test
    public void test() throws IOException {

        LockDemo lock = new LockDemo();


        for (int i = 0; i < 10; i++) {
            executors.submit(() -> {
                try {
                    lock.addOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            });
        }


        executors.shutdown();

        while (!executors.isTerminated()) {

        }


        System.out.println(lock.getCount());

    }


    @Data
    static class LockDemo {

        //初始化信号量
        int count;

        //用信号量保证互斥
        final Semaphore s = new Semaphore(1);

        void addOne() throws InterruptedException {
            s.acquire();
            try {
                count+=1;
            } finally {
                s.release();
            }
        }

    }




}
