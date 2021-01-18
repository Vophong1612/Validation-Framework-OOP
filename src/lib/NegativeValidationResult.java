package lib;

public class NegativeValidationResult implements IValidationResult {

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
}
