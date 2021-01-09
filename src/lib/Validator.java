package lib;


public interface Validator<T> {
    static <T> DefaultValidatorBuilder<T> of(Class<T> validatedType) {
        return new DefaultValidatorBuilder<>(validatedType);
    }

    ValidationResult<T> validate(T subject);
}
