package lib;


import java.util.Objects;
import java.util.Set;

public class NegativeValidationResult<T> implements ValidationResult<T> {

    private final T subject;
    private final String processedValidations;

    NegativeValidationResult(T subject, String processedValidations) {
        this.subject = subject;
        this.processedValidations = processedValidations;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public T getValue() {
        return subject;
    }

    @Override
    public String processedValidations() {
        return processedValidations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NegativeValidationResult<?> that = (NegativeValidationResult<?>) o;
        if (!Objects.equals(subject, that.subject)) return false;
        return Objects.equals(processedValidations, that.processedValidations);
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (processedValidations != null ? processedValidations.hashCode() : 0);
        return result;
    }
}
