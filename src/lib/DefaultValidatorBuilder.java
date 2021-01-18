package lib;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class DefaultValidatorBuilder implements IValidatorBuilder {

    private final Map<Predicate<String>, String> validations = new HashMap<>();

    protected DefaultValidatorBuilder() {
	}

    @Override
    public DefaultValidatorBuilder validation(Predicate<String> validation, String message) {
        validations.put(validation, message);
        return this;
    }

    @Override
    public AbtractValidator build() {
        return new DefaultValidator(validations);
    }

    @Override
    public String toString() {
        return "Validator for String";
    }
}