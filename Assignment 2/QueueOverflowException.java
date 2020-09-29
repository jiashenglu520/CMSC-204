package ass2;

/**
 * This exception is thrown when an enqueue method is called on a full queue.
 * @author Jiasheng Lu
 */
public class QueueOverflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for queue overflow
     */
    public QueueOverflowException() {
        super("The queue is full");
    }
}
