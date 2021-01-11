package lib;


import java.util.Objects;
import java.util.Set;

public class NegativeValidationResult implements ValidationResult {

    private final String value;
    private final String message;

    public NegativeValidationResult(String value, String message) {
        this.value = value;
        this.message = message;
    }

    @Override
    public boolean isValid() {
        return false;
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
//        NegativeValidationResult<?> that = (NegativeValidationResult<?>) o;
//        if (!Objects.equals(value, that.value)) return false;
//        return Objects.equals(message, that.message);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = value != null ? value.hashCode() : 0;
//        result = 31 * result + (message != null ? message.hashCode() : 0);
//        return result;
//    }
}
