package demo;
import lib.ValidationResult;
import lib.Validator;

public class Main {
	private final static Validator<MovieCharacter> characterValidator = Validator.of(MovieCharacter.class)
            .validation(character -> character.value.length() > 0, "name needs to has to be at least 1 character long")
            .validation(character -> Character.isUpperCase(character.value.charAt(0)), "name needs to start with uppercase letter")
            .validation(character -> character.value.length() < 50, "name needs to has to be shorter than 50 characters")
            .ensure();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieCharacter character = new MovieCharacter("Konna pinciotti");
        //when
        ValidationResult<MovieCharacter> validationResult = characterValidator.validate(character);
        Validator.of(String.class);
        System.out.print(validationResult.processedValidations());
	}
}
