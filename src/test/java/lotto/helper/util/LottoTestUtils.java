package lotto.helper.util;

import java.lang.reflect.Field;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.helper.exception.CannotReflectionException;

public final class LottoTestUtils {

    private static final String NUMBERS_FIELD_NAME = "numbers";

    private LottoTestUtils() {
    }

    @SuppressWarnings("unchecked")
    public static final List<LottoNumber> findNumbers(Lotto lotto) {
        Field numbers = ReflectionFieldUtils.processReflectionField(Lotto.class, NUMBERS_FIELD_NAME);

        try {
            return (List<LottoNumber>) numbers.get(lotto);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
