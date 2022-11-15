package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Calculator;
import lotto.domain.Lotto;

public class CalculatorTest {
    @DisplayName("결과 리스트가 잘 업데이트 되는지 확인")
    @Test
    void calRankTest() {
        List<Integer> result = Arrays.asList(0, 0, 0, 0, 0);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        Calculator.calRank(result, lottos, numbers, bonus);
        assertThat(result).isEqualTo(List.of(1, 1, 1, 0, 0));
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void catRevenueTest() {
        List<Integer> result = Arrays.asList(0, 0, 1, 1, 1);
        double revenue = Calculator.calRevenue(result, 10000000);
        assertThat(revenue).isEqualTo(15.6);
    }
}
