package lib;

public class TimeValidatorBuilder extends DefaultValidatorBuilder {
	
	protected TimeValidatorBuilder() {
		this.validation(character -> java.util.regex.Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$").matcher(character).find(), "Enter valid time HH:MM");
	}
}