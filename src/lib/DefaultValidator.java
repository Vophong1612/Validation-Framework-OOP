package lib;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class DefaultValidator<T> implements Validator<T> {

    private final Map<Predicate<T>, String> validations;

    DefaultValidator(Map<Predicate<T>, String> validations) {
        this.validations = validations;
    }

    @Override
    public ValidationResult<T> validate(T subject) {
        return validations.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().test(subject))
                .findFirst()
                .<ValidationResult<T>>map(entry -> new NegativeValidationResult<>(subject, entry.getValue()))
                .orElseGet(() -> new PositiveValidationResult<>(subject, "Correct"));
    }
}
