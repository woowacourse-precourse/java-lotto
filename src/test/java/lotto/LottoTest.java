package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Lotto makeBasicLottoForTest() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
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

    @ParameterizedTest(name = "1~45외의 숫자로 로또 생성시 예외 발생 테스트 [{index}] : {5} 입력")
    @CsvSource(value = {"1,2,3,4,5,47", "1,2,3,4,5,0"})
    void createLottoByNumbersOutOfRange(int num1, int num2, int num3, int num4, int num5, int num6) {
        assertThatThrownBy(() -> new Lotto(List.of(num1, num2, num3, num4, num5, num6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.NUMBER_INPUT_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("로또 toString() 형식 테스트")
    @Test
    void toStringTest() {
        Lotto lotto = makeBasicLottoForTest();
        String expectedToString = "[1, 2, 3, 4, 5, 6]";
        assertThat(lotto.toString()).isEqualTo(expectedToString);
    }

    @ParameterizedTest(name = "로또 번호 포함 테스트 [{index}] : {1} 반환")
    @CsvSource(value = {"3,true", "9,false"})
    void isContainNumberTest(int number, boolean expected) {
        Lotto lotto = makeBasicLottoForTest();
        assertThat(lotto.containNumber(number)).isEqualTo(expected);
    }
}
