package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.domain.CalculationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationResultTest {

    private static final List<List<Integer>> lotteries = List.of(List.of(1,2,3,4,5,6),List.of(1,2,3,4,6,7));
    private static final List<Integer> answer = List.of(1,2,3,4,5,11);
    private static final int bonusNumber = 6;
    private static final int userInputMoney = 80000;
    private static final int TOTAL_Prize = 30_050_000;
    private static final double VALID_RATE = 37562.5f;
    private CalculationResult calculationResult;

    @BeforeEach
    void init() {
        this.calculationResult = new CalculationResult();
    }

    @DisplayName("상금이 정확히 계산되는지 테스트")
    @Test
    void checkPrizeCalculation() {
        calculationResult.calculateResult(lotteries,bonusNumber,answer);
        assertThat(calculationResult.calculateTotalPrize()).isEqualTo(TOTAL_Prize);
    }

    @DisplayName("수익률이 정확히 계산되는지 테스트")
    @Test
    void checkRateCalculation() {
        assertThat(calculationResult.calculateRate(userInputMoney,TOTAL_Prize)).isEqualTo(VALID_RATE);
    }
}
