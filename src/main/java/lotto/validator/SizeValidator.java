package lotto.validator;

import java.util.List;

public interface SizeValidator<T extends List<?>> {

    default boolean isValidSize(final T target, final int size) {
        return target.size() == size;
    }
}
