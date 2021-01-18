package lib;

import java.util.regex.Pattern;

public class PhoneNumberValidatorBuilder extends DefaultValidatorBuilder {
    
    protected PhoneNumberValidatorBuilder () {
    	this.validation(string -> Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})\\b").matcher(string).matches(), "Phone number is not valid");
    }
}