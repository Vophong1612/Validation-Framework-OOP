package demo;
import lib.ValidationResult;
import lib.Validator;

public class Main {
	private final static Validator characterValidator = Validator.getBuilder()
            .validation(character -> character.length() > 0, "name needs to has to be at least 1 character long")
            .validation(character -> Character.isUpperCase(character.charAt(0)), "name needs to start with uppercase letter")
            .validation(character -> character.length() < 50, "name needs to has to be shorter than 50 characters")
            .ensure();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //when
        ValidationResult validationResult = characterValidator.validate("Konna pinciotti");
        System.out.println(validationResult.processedValidations());
        System.out.println(validationResult.getValue());
	}
}
