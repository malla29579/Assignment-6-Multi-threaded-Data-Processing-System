import java.util.concurrent.*;

class Task {
    // Task definition with a simple description
    String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class Worker implements Runnable {
    private BlockingQueue<Task> taskQueue;

    public Worker(BlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        try {
            // Retrieve task from queue and simulate work
            Task task = taskQueue.take();  // Blocks if queue is empty
            System.out.println(Thread.currentThread().getName() + " is processing: " + task.getDescription());
            Thread.sleep(1000); // Simulate task processing time
            System.out.println(Thread.currentThread().getName() + " completed: " + task.getDescription());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

public class DataProcessingSystem {
    public static void main(String[] args) {
        // Create a BlockingQueue to handle tasks
        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();

        // ExecutorService to manage worker threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Add tasks to the queue
        for (int i = 0; i < 10; i++) {
            taskQueue.add(new Task("Task " + (i + 1)));
        }

        // Start worker threads
        for (int i = 0; i < 4; i++) {
            executorService.submit(new Worker(taskQueue));
        }

        // Shut down the executor service after all tasks are completed
        executorService.shutdown();
    }
}
