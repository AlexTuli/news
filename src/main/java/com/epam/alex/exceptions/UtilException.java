package com.epam.alex.exceptions;

/**
 * Created on 1/22/2016.
 *
 * @author Bocharnikov Alexander
 */
public class UtilException extends RuntimeException {

    public UtilException() {
        super();
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtilException(Throwable cause) {
        super(cause);
    }
}
