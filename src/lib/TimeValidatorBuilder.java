package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class TimeValidatorBuilder extends DefaultValidatorBuilder {
    public TimeValidatorBuilder() {
    	this.validation(character ->
    	{
    		if(character.length() != 5) return false;
    		else
    			return java.util.regex.Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]").matcher(character).find();
    	}, "Enter valid time");
	}
}