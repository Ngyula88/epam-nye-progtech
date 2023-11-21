package hu.nye.progtech.sudoku.service.exception;

/**
 * Exception to represent that a box was invalid.
 */
public class InvalidBoxException extends MapValidationException {

    public InvalidBoxException(String message) {
        super(message);
    }

}
