package lib;


public interface EnsuringValidatorBuilder<T> {
    Validator<T> ensure();
}
