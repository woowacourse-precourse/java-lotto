package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoStorage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.controller.Constants.PERCENTAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class EarningRateCalculatorTest {

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningRate() {
        int inputMoney = 8_000;
        int prizeSum = 0;
        double expected = 62.5;
        List<CorrectNumber> resultCollection = new ArrayList<>();
        resultCollection.add(CorrectNumber.THREE);
        for(CorrectNumber correctNumber : resultCollection) {
            prizeSum += correctNumber.getCashPrize();
        }
        assertThat(((double)prizeSum / inputMoney) * PERCENTAGE)
                .isEqualTo(expected);
    }
}
