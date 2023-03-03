package ma.usmba.customerservice.exceptions;

public class EmailAlreadyExistException extends Exception {
    public EmailAlreadyExistException(String message){
        super(message);
    }
}
