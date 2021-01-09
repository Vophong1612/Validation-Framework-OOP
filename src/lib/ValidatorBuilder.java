package lib;


import java.util.function.Predicate;

public interface ValidatorBuilder<T> {
    ValidatorBuilder<T> validation(Predicate<T> validation, String message);
}
