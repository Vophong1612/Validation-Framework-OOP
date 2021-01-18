package demo;

import lib.PositiveValidationResult;
import lib.IValidationResult;
import lib.AbtractValidator;
import lib.AbtractValidator.BuilderType;
import java.util.Map;
import java.util.function.Predicate;

class SystemOutValidator extends AbtractValidator {

    private final Map<Predicate<String>, String> validations;

    public SystemOutValidator(Map<Predicate<String>, String> validations) {
        this.validations = validations;
    }

    @Override
    public IValidationResult validate(String subject) {
        validations.forEach((key, value) -> {
        	if (key.test(subject)) 
        		System.out.println(String.format("'%s' passed!", value));
            else 
            	System.out.println(String.format("'%s' failed!", value));
        });
        return new PositiveValidationResult(subject, "");
    }
}


public class Main {
	
	private final static AbtractValidator stringValidator = AbtractValidator.getInstance(BuilderType.DEFAULT)
            .validation(character -> character.length() > 0, "name needs to has to be at least 1 character long")
            .validation(character -> Character.isUpperCase(character.charAt(0)), "name needs to start with uppercase letter")
            .validation(character -> character.length() < 50, "name needs to has to be shorter than 50 characters")
            .build();
	
	private final static AbtractValidator emailValidator = AbtractValidator.getInstance(BuilderType.EMAIL)
			.build();
	
	private final static AbtractValidator customValidator = AbtractValidator.getCustomBuilder(SystemOutValidator::new)
            .validation(character -> character.length() > 0, "name needs to has to be at least 1 character long")
            .validation(character -> character.length() < 50, "name needs to has to be shorter than 50 characters")
            .build();
	
	public static void main(String[] args) {

        IValidationResult stringValidateResult = stringValidator.validate("Konna pinciotti");
		IValidationResult emailvalidationResult = emailValidator.validate("vophong@gmail.com");
        System.out.println(stringValidateResult.processedValidations());
        System.out.println(emailvalidationResult.getValue());
		customValidator.validate("Konna pinciotti");
		
	}
}
