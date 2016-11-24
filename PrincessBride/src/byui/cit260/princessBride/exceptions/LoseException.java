/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.exceptions;

/**
 *
 * @author kellyjohnson
 */
public class LoseException extends RuntimeException{
    
     public LoseException() {
    }

    public LoseException(String message) {
        super(message);
    }

    public LoseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoseException(Throwable cause) {
        super(cause);
    }

    public LoseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
