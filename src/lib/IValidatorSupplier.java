package lib;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface IValidatorSupplier extends Function<Map<Predicate<String>, String>, AbtractValidator> {
}
