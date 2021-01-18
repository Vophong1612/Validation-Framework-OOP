package lib;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class CustomValidatorBuilder implements IValidatorBuilder{

    protected final Map<Predicate<String>, String> validations = new HashMap<>();
    private final IValidatorSupplier validatorSupplier;

    public CustomValidatorBuilder(IValidatorSupplier validatorSupplier) {
        this.validatorSupplier = validatorSupplier;
    }


    @Override
    public CustomValidatorBuilder validation(Predicate<String> validation, String message) {
        validations.put(validation, message);
        return this;
    }

    @Override
    public AbtractValidator build() {
        return validatorSupplier.apply(validations);
    }

    
}
