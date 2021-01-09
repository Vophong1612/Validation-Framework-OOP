package lib;


public interface Validator {
	static DefaultValidatorBuilder getBuilder() {
        return new DefaultValidatorBuilder();
    }
    ValidationResult validate(String subject);
}
