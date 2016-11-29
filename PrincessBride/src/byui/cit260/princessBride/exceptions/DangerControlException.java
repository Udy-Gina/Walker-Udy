/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.princessBride.exceptions;

/**
 *
 * @author lisawalker
 */
public class DangerControlException extends Exception {

    public DangerControlException() {
    }

    public DangerControlException(String message) {
        super(message);
    }

    public DangerControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public DangerControlException(Throwable cause) {
        super(cause);
    }

    public DangerControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
