package ma.usmba.compteservice.exceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message){
        super(message);
    }
}
