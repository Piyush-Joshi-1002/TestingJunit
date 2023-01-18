here are a few different libraries in Java that can be used to create a scheduler,
such as the java.util.Timer class or the java.util.concurrent.ScheduledExecutorService class.
Here's an example of how you might use the ScheduledExecutorService class to schedule 3 calls
per minute and 10 calls per hour for a "user controller" class:

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerExample {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Schedule 3 calls per minute
        Runnable task1 = new UserController();
        executor.scheduleAtFixedRate(task1, 0, 20, TimeUnit.SECONDS);

        // Schedule 10 calls per hour
        Runnable task2 = new UserController();
        executor.scheduleAtFixedRate(task2, 0, 360, TimeUnit.MINUTES);
    }

}
