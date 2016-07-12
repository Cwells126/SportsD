
package com.connectcard.exception;


public class ConnectCardException extends Exception {

    public ConnectCardException() {
        super();
    }

    public ConnectCardException(String message) {
        super(message);
    }

    public ConnectCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectCardException(Throwable cause) {
        super(cause);
    }
}
