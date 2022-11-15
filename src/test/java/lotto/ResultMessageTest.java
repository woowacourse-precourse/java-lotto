package lotto;

import lotto.domain.ResultMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.ResultMessage.increaseCountResult;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultMessageTest {

    @AfterEach
    public void init() {
        ResultMessage.initResultMessage();
    }


    @DisplayName("기능 테스트: 당첨된 번호별 카운트 증가 테스트")
    @Test
    void increaseCountResultTest() {
        int countResult = 3;
        boolean bonusNum = false;
        increaseCountResult(countResult, bonusNum);
        int actual = ResultMessage.THREE_CORRECT_NUMBERS.getCountResult();
        assertEquals(1, actual);
    }

    @DisplayName("기능 테스트: 당첨된 로또 수에 따른 당첨금 계산 테스트")
    @Test
    void calculateTotalWinningMoneyTest() {
        int countResult = 3;
        boolean bonusNum = false;
        increaseCountResult(countResult, bonusNum);

        int actual = ResultMessage.calculateTotalWinningMoney();

        assertEquals(5000, actual);
    }
}
