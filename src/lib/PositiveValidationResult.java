package lib;

public class PositiveValidationResult implements IValidationResult {

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

}
