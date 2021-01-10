package lib;


public interface Validator {
	static DefaultValidatorBuilder getDefaultBuilder() {
        return new DefaultValidatorBuilder();
    }
	static EmailValidatorBuilder getEmailBuilder() {
		return new EmailValidatorBuilder();
	}
    ValidationResult validate(String subject);
}
