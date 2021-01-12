package lib;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface ValidatorSupplier extends Function<Map<Predicate<String>, String>, Validator> {
}
