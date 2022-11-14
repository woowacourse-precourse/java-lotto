package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class ResultTest {
    private Result testResult;

    @BeforeEach
    void setUpResult() {
        testResult = new Result(List.of(3, 0, 0, 0, 2, 1, 0, 0), new PurchaseAmount(8000));
    }

    @DisplayName("당첨번호와 일치하는 개수가 3인 로또 수를 구한다")
    @Test
    void getNumberOfMatchCount() {
        int matchCount = 3;
        int numberOfMatchCount = testResult.getNumberOfMatchCount(matchCount);
        assertThat(numberOfMatchCount).isEqualTo(1);
    }

    @DisplayName("모든 당첨 개수를 구한다")
    @Test
    void getNumberOfMatchCounts() {
        List<Integer> numberOfMatchCounts = testResult.getNumberOfMatchCounts();
        assertThat(numberOfMatchCounts).isEqualTo(List.of(1, 0, 0, 0, 0));
    }

    @DisplayName("수익률을 계산한다")
    @Test
    void getPrizePerPurchaseAmount() {
        Double prizePerPurchaseAmount = testResult.getPrizePerPurchaseAmount();
        assertThat(prizePerPurchaseAmount).isEqualTo(62.5);
    }
}
