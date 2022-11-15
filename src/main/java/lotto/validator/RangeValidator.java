package lotto.validator;

public interface RangeValidator<T extends Comparable<T>> {

    default boolean isInRange(final T target, final T startInclusive,final T endInclusive) {
        return target.compareTo(startInclusive) >= 0 && target.compareTo(endInclusive) <= 0;
    }
}
