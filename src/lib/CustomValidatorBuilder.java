package lib;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomValidatorBuilder implements ValidatorBuilder{

    protected final Map<Predicate<String>, String> validations = new HashMap<>();
    private final ValidatorSupplier validatorSupplier;

    public CustomValidatorBuilder(ValidatorSupplier validatorSupplier) {
        this.validatorSupplier = validatorSupplier;
    }


    @Override
    public CustomValidatorBuilder validation(Predicate<String> validation, String message) {
        validations.put(validation, message);
        return this;
    }

    @Override
    public Validator ensure() {
        return validatorSupplier.apply(validations);
    }

    
}
