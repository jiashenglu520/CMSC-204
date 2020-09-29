package ass2;
/**
 * This exception is thrown when the notation format is invalid.
 * @author Jiasheng Lu
 */
public class InvalidNotationFormatException extends RuntimeException {
    
    /**
     * No-arg constructor with default message for invalid notation format
     */
    public InvalidNotationFormatException() {
        super("Notation format is invalid");
    }
}
