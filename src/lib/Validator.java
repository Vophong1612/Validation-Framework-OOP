package lib;


public interface Validator {
//	static DefaultValidatorBuilder getDefaultBuilder() {
//        return new DefaultValidatorBuilder();
//    }
//	static EmailValidatorBuilder getEmailBuilder() {
//		return new EmailValidatorBuilder();
//	}
	static ValidatorBuilder getBuilder(String Name) {
		if (Name == "Email") {
			return new EmailValidatorBuilder();
		} else {
			return new DefaultValidatorBuilder();
		}
	}
    ValidationResult validate(String subject);
}
