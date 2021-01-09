package lib;


import java.util.function.Predicate;

public interface ValidatorBuilder {
    ValidatorBuilder validation(Predicate<String> validation, String message);
}
