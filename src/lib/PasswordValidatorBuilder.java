package lib;

public class PasswordValidatorBuilder extends DefaultValidatorBuilder {
    protected PasswordValidatorBuilder() {
    	this.validation(character -> java.util.regex.Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).*[A-Za-z0-9].{7,}$").matcher(character).find(), 
    			"At least 8 characters(1 digit, lowercase, uppercase, @#$%^&+= no whitespace");
	}
}