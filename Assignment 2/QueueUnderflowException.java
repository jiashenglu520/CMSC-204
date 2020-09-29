package ass2;

/**
 * This exception is thrown when a dequeue method is called on an empty queue.
 * @author Jiasheng Lu
 */
public class QueueUnderflowException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for queue underflow
     */
    public QueueUnderflowException() {
        super("The queue is empty");
    }
}
