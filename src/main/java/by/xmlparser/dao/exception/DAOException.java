package by.xmlparser.dao.exception;

import java.io.Serializable;

public class DAOException extends Exception implements Serializable {

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }


}
