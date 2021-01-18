package lib;

public class EmailValidatorBuilder extends DefaultValidatorBuilder {
    protected EmailValidatorBuilder() {
    	this.validation(character -> java.util.regex.Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$").matcher(character).find(), "Enter valid email");
	}
}