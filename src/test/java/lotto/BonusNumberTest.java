package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.ResultMessage;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusNumberTest {
    @AfterEach
    public void init() {
        ResultMessage.initResultMessage();
    }

    @DisplayName("예외 테스트: 보너스 번호로 빈 문자열이 들어오는 경우")
    @Test
    void BonusNumberNullTest() {
        WinningLotto winningLotto = new WinningLotto("5,6,7,8,9,10");
        String input = "";

        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("예외 테스트: 보너스 번호가 1~45 범위에서 벗어나는 경우")
    @Test
    void BonusNumberOutOfRangeTest() {
        WinningLotto winningLotto = new WinningLotto("5,6,7,8,9,10");
        String input = "0";

        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("예외 테스트: 보너스 번호에 숫자가 아닌 문자가 포함된 경우")
    @Test
    void BonusNumberNumericTest() {
        WinningLotto winningLotto = new WinningLotto("5,6,7,8,9,10");
        String input = "1,";

        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 보너스 번호가 당첨 번호와 중복 될 경우")
    @Test
    void BonusNumberDuplicationTest() {
        WinningLotto winningLotto = new WinningLotto("5,6,7,8,9,10");
        String input = "5";

        assertThatThrownBy(() -> new BonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("기능 테스트: 당첨번호와 하나의 로또 번호 비교")
    @Test
    void compareLottoAndWinningLotto() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNums = List.of(3, 4, 5, 6, 7, 8);
        int bonusNum = 10;

        BonusNumber.compareLotto(lotto, winningNums, bonusNum);
        int count = ResultMessage.FOUR_CORRECT_NUMBERS.getCountResult();

        assertEquals(1, count);
    }
}
