package lib;


import java.util.Objects;
import java.util.Set;

public class PositiveValidationResult implements ValidationResult {

    private final String value;
    private final String message;

    public PositiveValidationResult(String value, String message) {
        this.value = value;
        this.message = message;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String processedValidations() {
        return message;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PositiveValidationResult<?> that = (PositiveValidationResult<?>) o;
//        if (!Objects.equals(subject, that.subject)) return false;
//        return Objects.equals(processedValidations, that.processedValidations);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = subject != null ? subject.hashCode() : 0;
//        result = 31 * result + (processedValidations != null ? processedValidations.hashCode() : 0);
//        return result;
//    }
}
