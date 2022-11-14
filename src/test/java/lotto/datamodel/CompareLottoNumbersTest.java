package lotto.datamodel;

import static org.assertj.core.api.Assertions.*;

import lotto.datamodel.enumdata.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.lang.reflect.Method;

class CompareLottoNumbersTest {
    CompareLottoNumbers compare = new CompareLottoNumbers(List.of(5,8,14,23,35,37), 10);
    @DisplayName("당첨된 로또표의 가격을 저장한다.")
    @Test
    void saveWinPrize() {
        List<Integer> result = compare.calculator(6, List.of(List.of(1,2,3,4,5,6),
                                                                        List.of(5,8,14,22,26,30),
                                                                        List.of(5,8,14,23,26,30),
                                                                        List.of(12,18,33,39,40,44),
                                                                        List.of(4,9,19,29,39,43),
                                                                        List.of(7,15,17,24,26,31)));
        assertThat(result).usingRecursiveComparison().isEqualTo(List.of(5000,50000));
    }

    @DisplayName("생성된 로또 번호 한줄을 받아서 당첨번호와 비교하여 몇등인지 알려준다")
    @Test
    void createEnumValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = compare.getClass().getDeclaredMethod("checkSameNumber", List.class);
        method.setAccessible(true);

        Object result = method.invoke(compare, List.of(5,8,14,22,26,30));

        assertThat(result).isEqualTo(Rank.FIFTH);
    }
}
