package lib;


public abstract class AbtractValidator {
	public enum BuilderType{
		DEFAULT, EMAIL, PHONE_NUMBER, PASSWORD, TIME;
	}
	private static DefaultValidatorBuilder defaultValidatorBuilder = null;
	private static EmailValidatorBuilder emailValidatorBuilder = null;
	private static PhoneNumberValidatorBuilder phoneNumberValidatorBuilder = null;
	private static PasswordValidatorBuilder passwordValidatorBuilder = null;
	private static TimeValidatorBuilder timeValidatorBuilder = null;
	
	public static IValidatorBuilder getInstance(BuilderType type) {
		switch (type) {
		case DEFAULT:
			if(defaultValidatorBuilder == null)
				defaultValidatorBuilder = new DefaultValidatorBuilder();
			return defaultValidatorBuilder;
		case EMAIL:
			if(emailValidatorBuilder == null){
				emailValidatorBuilder = new EmailValidatorBuilder();
			}
			return emailValidatorBuilder;
		case PHONE_NUMBER:
			if(phoneNumberValidatorBuilder == null)
				phoneNumberValidatorBuilder = new PhoneNumberValidatorBuilder();
			return phoneNumberValidatorBuilder;
		case PASSWORD:
			if(passwordValidatorBuilder == null)
				passwordValidatorBuilder = new PasswordValidatorBuilder();
			return passwordValidatorBuilder;
		case TIME:
			if(timeValidatorBuilder == null)
				timeValidatorBuilder = new TimeValidatorBuilder();
			return timeValidatorBuilder;
		}
		return null;
	}
	public static CustomValidatorBuilder getCustomBuilder(IValidatorSupplier validatorSupplier) {
		return new CustomValidatorBuilder(validatorSupplier);
	}
	
    public abstract IValidationResult validate(String subject);
}
