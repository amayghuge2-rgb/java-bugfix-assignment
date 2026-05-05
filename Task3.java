import java.util.concurrent.*;
import java.util.*;

public class Task3 {

    // FIX: Use AtomicInteger for thread-safe increment
    private java.util.concurrent.atomic.AtomicInteger processedCount = new java.util.concurrent.atomic.AtomicInteger(0);

    public void process(List<StatementRecord> records) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);
                // FIX: Atomic increment prevents race condition
                processedCount.incrementAndGet();
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getProcessedCount() {
        return processedCount.get();
    }

    private void processRecord(StatementRecord record) {}
}
