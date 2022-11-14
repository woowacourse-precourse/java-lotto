package lotto.domain;

import lotto.service.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("당첨 내역에 따라 수익률을 계산한다.")
    @Test
    void getCountMatchingNumber() {
        //give
        List<Rank> ranks = RankGenerator.getRanks();
        //when
        for (Rank rank : ranks) {
            rank.addCount();
        }
        int quantity = 10000; //1,000만원 쓴 상황
        //then
        Assertions.assertThat(Calculator.getYield(ranks, quantity))
                .isEqualTo(20315.55);
    }
}
