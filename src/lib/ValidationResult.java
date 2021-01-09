package lib;


import java.util.Set;

public interface ValidationResult<T> {

    boolean isValid();

    T getValue();

    String processedValidations();
}
