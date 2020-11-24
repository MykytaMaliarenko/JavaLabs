import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;

public class TestCSVParserWorker {
    private Thread thread;

    private BlockingQueue<String> inputQueue;
    private BlockingQueue<String> outputQueue;

    private void init() {
        CSVParser parser = new CSVParser();

        this.inputQueue = new LinkedBlockingQueue<>(1);
        this.outputQueue = new LinkedBlockingQueue<>(1);

        CSVParserWorker instance = new CSVParserWorker(parser, inputQueue, outputQueue);
        thread = new Thread(instance);
        thread.start();
    }

    @Test
    public void testDefaultRun() throws InterruptedException {
        this.init();
        inputQueue.put("a,b,c");
        String result = outputQueue.take();
        assertEquals("1+1+1", result);

        thread.interrupt();
    }
}
