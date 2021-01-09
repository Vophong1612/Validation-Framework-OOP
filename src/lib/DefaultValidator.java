package lib;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class DefaultValidator implements Validator {

    private final Map<Predicate<String>, String> validations;

    DefaultValidator(Map<Predicate<String>, String> validations) {
        this.validations = validations;
    }

    @Override
    public ValidationResult validate(String value) {
        return validations.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().test(value))
                .findFirst()
                .<ValidationResult>map(entry -> new NegativeValidationResult(value, entry.getValue()))
                .orElseGet(() -> new PositiveValidationResult(value, "Correct"));
    }
}
