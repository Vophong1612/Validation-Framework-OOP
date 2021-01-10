package demo;
import lib.DefaultValidator;
import lib.EmailValidator;
import lib.ValidationResult;
import lib.Validator;

public class Main {
	
//	private final static Validator stringValidator = Validator.getDefaultBuilder()
//            .validation(character -> character.length() > 0, "name needs to has to be at least 1 character long")
//            .validation(character -> Character.isUpperCase(character.charAt(0)), "name needs to start with uppercase letter")
//            .validation(character -> character.length() < 50, "name needs to has to be shorter than 50 characters")
//            .ensure();
	
	private final static Validator emailValidator = Validator.getEmailBuilder()
			.validation(character -> Character.isUpperCase(character.charAt(0)), "name needs to start with uppercase letter")
			.ensure();
	
	public static void main(String[] args) {

//        ValidationResult validationResult = stringValidator.validate("Konna pinciotti");
		ValidationResult validationResult = emailValidator.validate("Vophong1612@gmail.com");
        System.out.println(validationResult.processedValidations());
        System.out.println(validationResult.getValue());
		
	}
}
