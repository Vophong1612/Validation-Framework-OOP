package lib;

import java.util.Map;
import java.util.function.Predicate;

public class DefaultValidator extends AbtractValidator {

    private final Map<Predicate<String>, String> validations;

    DefaultValidator(Map<Predicate<String>, String> validations) {
        this.validations = validations;
    }

    @Override
    public IValidationResult validate(String value) {
        return validations.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().test(value))
                .findFirst()
                .<IValidationResult>map(entry -> new NegativeValidationResult(value, entry.getValue()))
                .orElseGet(() -> new PositiveValidationResult(value, "Correct"));
    }
}
