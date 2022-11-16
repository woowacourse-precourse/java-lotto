package lotto;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.BonusNumber;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;

public class ResultTest {
    private Result result;

    @BeforeEach
    void generateResult() {
        List<List<Integer>> purchasedLotteries = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        this.result = new Result(purchasedLotteries, winningNumbers, bonusNumber);
    }

    @DisplayName("당첨 결과 확인 테스트")
    @Test
    void checkCountWinningCase() {
        result.countWinningCase();
        Map<String, Integer> resultMap = result.getResultMap();

        int firstResult = resultMap.get("first");
        int secondResult = resultMap.get("second");
        int thirdResult = resultMap.get("third");
        int fourthResult = resultMap.get("fourth");
        int fifthResult = resultMap.get("fifth");

        boolean result = firstResult == 1
                && secondResult == 1
                && thirdResult == 1
                && fourthResult == 1
                && fifthResult == 1;

        Assertions.assertThat(result).isTrue();
    }
}
