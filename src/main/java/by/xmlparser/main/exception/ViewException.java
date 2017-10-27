package by.xmlparser.main.exception;

import java.io.Serializable;

public class ViewException extends Exception implements Serializable {

    public ViewException() {
    }

    public ViewException(String message) {
        super(message);
    }

    public ViewException(String message, Throwable cause) {
        super(message, cause);
    }
}
