package lib;


public interface Validator {
	static DefaultValidatorBuilder getDefaultBuilder() {
        return new DefaultValidatorBuilder();
    }
	static EmailValidatorBuilder getEmailBuilder() {
		return new EmailValidatorBuilder();
	}
	static PhoneNumberValidatorBuilder getPhoneBuilder() {
		return new PhoneNumberValidatorBuilder();
	}
	static PasswordValidatorBuilder getPasswordBuilder() {
		return new PasswordValidatorBuilder();
	}
    ValidationResult validate(String subject);
}
