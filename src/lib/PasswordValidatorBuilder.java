package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class PasswordValidatorBuilder extends DefaultValidatorBuilder {
    public PasswordValidatorBuilder() {
    	this.validation(character -> java.util.regex.Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).*[A-Za-z0-9].{7,}$").matcher(character).find(), 
    			"At least 8 characters(1 digit, lowercase, uppercase, @#$%^&+= no whitespace");
	}
}