package by.xmlparser.service.exception;

import java.io.Serializable;

public class ServiceException extends Exception implements Serializable {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
