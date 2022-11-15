package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoAnswerTest {
    @Test
    @DisplayName("기본흐름: 사용자가 올바른 당첨 번호와 보너스 번호를 입력한 경우")
    void LottoOrder_ValidInput_Success() {
        assertThatNoException().isThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "7"));
    }

    @Test
    @DisplayName("예외흐름: 사용자가 숫자가 아닌 값을 입력한 경우1")
    void LottoOrder_InvalidInput1_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,two,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 사용자가 숫자가 아닌 값을 입력한 경우2")
    void LottoOrder_InvalidInput2_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "seven"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우1")
    void LottoOrder_InvalidRange1_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("0,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우2")
    void LottoOrder_InvalidRange2_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,46", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우3")
    void LottoOrder_InvalidRange3_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우4")
    void LottoOrder_InvalidRange4_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "47"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 중복된 숫자를 입력한 경우1")
    void LottoOrder_DuplicateNumber1_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,5", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.DUPLICATE_LOTTO_NUMBER.toString());
    }

    @Test
    @DisplayName("예외흐름: 중복된 숫자를 입력한 경우2")
    void LottoOrder_DuplicateNumber2_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.DUPLICATE_LOTTO_NUMBER.toString());
    }

    @Test
    @DisplayName("구매 번호와 당첨 번호 일치 개수 3개일 때 테스트")
    void getCorrectCount_MatchThree_Return3() {
        LottoAnswer base = new LottoAnswer("10,20,30,1,3,5", "45");
        Lotto target = new Lotto(Arrays.asList(1, 10, 3, 4, 22, 33));
        assertThat(base.getCorrectCount(target)).isEqualTo(3);
    }

    @Test
    @DisplayName("구매 번호와 당첨 번호 일치 개수 6개일 때 테스트")
    void getCorrectCount_MatchSix_Return6() {
        LottoAnswer base = new LottoAnswer("10,20,30,1,3,5", "45");
        Lotto target = new Lotto(Arrays.asList(3, 10, 20, 1, 5, 30));
        assertThat(base.getCorrectCount(target)).isEqualTo(6);
    }

    @Test
    @DisplayName("구매 번호와 당첨 번호 일치 개수 0개일 때 테스트")
    void getCorrectCount_MatchZero_Return0() {
        LottoAnswer base = new LottoAnswer("10,20,30,1,3,5", "45");
        Lotto target = new Lotto(Arrays.asList(11, 22, 33, 2, 4, 6));
        assertThat(base.getCorrectCount(target)).isEqualTo(0);
    }

    @Test
    @DisplayName("구매 번호에 보너스 번호가 있을 때 테스트")
    void isContainBonus_MatchOne_ReturnTrue() {
        LottoAnswer base = new LottoAnswer("10,20,30,1,3,5", "45");
        Lotto target = new Lotto(Arrays.asList(10, 20, 30, 1, 3, 45));
        assertThat(base.isContainBonus(target)).isEqualTo(true);
    }

    @Test
    @DisplayName("구매 번호에 보너스 번호가 없을 때 테스트")
    void isContainBonus_MatchZero_ReturnFalse() {
        LottoAnswer base = new LottoAnswer("10,20,30,1,3,5", "45");
        Lotto target = new Lotto(Arrays.asList(10, 20, 30, 1, 3, 5));
        assertThat(base.isContainBonus(target)).isEqualTo(false);
    }
}