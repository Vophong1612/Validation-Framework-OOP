package lib;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class DefaultValidatorBuilder implements ValidatorBuilder {

    private final Map<Predicate<String>, String> validations = new HashMap<>();

//    public DefaultValidatorBuilder(Class<T> validatedType) {
//        this.validatedType = validatedType;
//    }

    protected DefaultValidatorBuilder() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public DefaultValidatorBuilder validation(Predicate<String> validation, String message) {
        validations.put(validation, message);
        return this;
    }

    @Override
    public Validator ensure() {
        return new DefaultValidator(validations);
    }

    @Override
    public String toString() {
        return "Validator for String";
    }
}