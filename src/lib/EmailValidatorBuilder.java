package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailValidatorBuilder implements ValidatorBuilder, EnsuringValidatorBuilder {

    private final Map<Predicate<String>, String> validations = new HashMap<>();

    public EmailValidatorBuilder() {
    	validations.put(character -> character.contains("@"), "Email need contain '@' character");
	}

    @Override
    public EmailValidatorBuilder validation(Predicate<String> validation, String message) {
        validations.put(validation, message);
        return this;
    }

    @Override
    public Validator ensure() {
        return new EmailValidator(validations);
    }

    @Override
    public String toString() {
        return "Validator for Email";
    }
}