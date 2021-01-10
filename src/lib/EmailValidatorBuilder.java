package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailValidatorBuilder extends DefaultValidatorBuilder {
    public EmailValidatorBuilder() {
    	this.validation(character -> java.util.regex.Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$").matcher(character).find(), "Enter valid email");
	}
}