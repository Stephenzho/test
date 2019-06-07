package thread;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorTest {



    @Test
    public void exeTest(){

        Executors.newCachedThreadPool();

        Executors.newFixedThreadPool(12);

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(12);

        Executors.newSingleThreadExecutor();

        Executors.newWorkStealingPool();





    }

}
