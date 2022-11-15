package lotto.validator;

import java.util.List;

public interface DuplicateValidator<T> {

    default boolean isDuplicate(final List<T> target) {
        return target.size() == target.stream().distinct().count();
    }
}
