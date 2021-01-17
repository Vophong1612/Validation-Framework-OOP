package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class PhoneNumberValidatorBuilder extends DefaultValidatorBuilder {
    
    protected PhoneNumberValidatorBuilder () {
    	this.validation(character -> character.substring(0,1).compareTo("0") == 0 , "First number must be 0");
    	this.validation(character -> character.substring(1,2).compareTo("0") != 0, "Second number can not be 0");
    	this.validation(character -> character.length() == 10, "Length of phone number must be 10");
    }
}