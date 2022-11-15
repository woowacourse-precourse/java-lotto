package lotto.model;

import static lotto.constants.LottoConstant.LOTTO_NUMBER_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private List<Integer> numbers;
    private Lotto testLotto;

    void setUp() {
        numbers = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1));
        testLotto = new Lotto(numbers);
    }

    @Test
    @DisplayName("유효하지 않은 로또 번호이라면 객체가 생성되지 않고 예외를 반환한다.")
    void checkLottoConstructorWithInvalidNumbers() {
        //given
        List<Integer> invalidNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        //when, then
        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("특정 숫자가 포함되어있는지 여부를 올바르게 반환한다.")
    void checkIsContain() {
        //given
        setUp();
        int compareNumber = 3;

        //when
        boolean result = testLotto.isContain(compareNumber);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("로또의 numbers 를 오름차순으로 정렬하여 문자열로 반환한다.")
    void checkToString() {
        //given
        setUp();

        //when
        String result = testLotto.toString();
        result = result.replaceAll(" ", "");
        result = result.substring(1, result.length() - 2);
        String[] tempResult = result.split(LOTTO_NUMBER_SEPARATOR);
        int[] afterResult = Arrays.stream(tempResult).mapToInt(Integer::parseInt).toArray();

        //then
        assertThat(afterResult[0] < afterResult[1]).isTrue();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
