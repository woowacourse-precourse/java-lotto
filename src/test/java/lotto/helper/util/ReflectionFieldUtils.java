package lotto.helper.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import lotto.helper.exception.FieldNotFoundException;

public final class ReflectionFieldUtils {

    private ReflectionFieldUtils() {
    }

    public static <T> Field processReflectionField(Class<T> clazz, String fieldName) {
        Field field = Arrays.stream(clazz.getDeclaredFields())
                .filter(target -> target.getName().equals(fieldName))
                .findAny().orElseThrow(FieldNotFoundException::new);

        field.setAccessible(true);
        return field;
    }
}
