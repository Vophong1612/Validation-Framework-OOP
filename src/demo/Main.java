package demo;
import lib.DefaultValidator;
import lib.DefaultValidatorBuilder;
import lib.EmailValidatorBuilder;
import lib.NegativeValidationResult;
import lib.PositiveValidationResult;
import lib.ValidationResult;
import lib.Validator;

import java.util.HashSet;
import java.util.Map;
import java.util.function.Predicate;



public class Main {
	
//	private final static Validator stringValidator = Validator.getDefaultBuilder()
//            .validation(character -> character.length() > 0, "name needs to has to be at least 1 character long")
//            .validation(character -> Character.isUpperCase(character.charAt(0)), "name needs to start with uppercase letter")
//            .validation(character -> character.length() < 50, "name needs to has to be shorter than 50 characters")
//            .ensure();
	
	private final static Validator emailValidator = Validator.getEmailBuilder()
			.ensure();
	
	private final static Validator customValidator = Validator.getCustomBuilder(SystemOutValidator::new)
            .validation(character -> character.length() > 0, "name needs to has to be at least 1 character long")
            .validation(character -> character.length() < 50, "name needs to has to be shorter than 50 characters")
            .ensure();
	
	public static void main(String[] args) {

//        ValidationResult validationResult = stringValidator.validate("Konna pinciotti");
//		ValidationResult validationResult = emailValidator.validate("vophong@gmail.com");
//        System.out.println(validationResult.processedValidations());
//        System.out.println(validationResult.getValue());
		customValidator.validate("Konna pinciotti");
		
	}
	
	static class SystemOutValidator implements Validator {

        private final Map<Predicate<String>, String> validations;

        public SystemOutValidator(Map<Predicate<String>, String> validations) {
            this.validations = validations;
        }

        @Override
        public ValidationResult validate(String subject) {
            validations.forEach((key, value) -> {
            	if (key.test(subject)) 
            		System.out.println(String.format("'%s' passed!", value));
                else 
                	System.out.println(String.format("'%s' failed!", value));
            });
            return new PositiveValidationResult(subject, "");
        }
	}
}
