package lotto.helper.util;

import java.lang.reflect.Field;
import lotto.domain.number.LottoNumber;
import lotto.helper.exception.CannotReflectionException;

public final class LottoNumberTestUtils {

    private static final String NUMBER_FIELD_NAME = "number";

    public LottoNumberTestUtils() {
    }

    public static int findNumber(LottoNumber lottoNumber) {
        Field numberField = ReflectionFieldUtils.processReflectionField(LottoNumber.class, NUMBER_FIELD_NAME);

        try {
            return (int) numberField.get(lottoNumber);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
