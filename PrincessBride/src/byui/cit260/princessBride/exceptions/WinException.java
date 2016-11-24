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
public class WinException extends RuntimeException{
    
    public WinException() {
    }

    public WinException(String message) {
        super(message);
    }

    public WinException(String message, Throwable cause) {
        super(message, cause);
    }

    public WinException(Throwable cause) {
        super(cause);
    }

    public WinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
