package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class TimeValidatorBuilder extends DefaultValidatorBuilder {
	
	protected TimeValidatorBuilder() {
		this.validation(character -> character.length() == 5, "Enter valid time HH:MM");
		this.validation(character -> java.util.regex.Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]").matcher(character).find(), "Enter valid time HH:MM");
	}
}