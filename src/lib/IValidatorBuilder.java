package lib;


import java.util.function.Predicate;

public interface IValidatorBuilder {
    IValidatorBuilder validation(Predicate<String> validation, String message);
    AbtractValidator build();
}
