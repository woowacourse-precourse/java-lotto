package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    List<List<Integer>> lottoSet = List.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(1, 2, 3, 4, 5, 7),
            List.of(1, 2, 3, 4, 5, 16),
            List.of(1, 2, 3, 4, 15, 16),
            List.of(1, 2, 3, 14, 15, 16)
    );

    List<Integer> winningLotto = List.of(
            1, 2, 3, 4, 5, 6, 7
    );
    Calculator calculator = new Calculator(lottoSet, winningLotto);

    @DisplayName("보너스 번호가 잘 입력되었는지 확인")
    @Test
    void checkBonus() {
        assertThat(calculator.bonus).isEqualTo(7);
    }

    @DisplayName("랜덤으로 생성한 로또 번호와 당첨 번호를 비교하여 몇 개 맞았는지 계산")
    @Test
    void checkCorrectNumberCount() {
        List<Integer> lottoNumber = lottoSet.get(0);

        for (Integer winningNumber : winningLotto) {
            calculator.countCalculator(lottoNumber, winningNumber);
        }

        assertThat(calculator.cnt).isEqualTo(6);
    }

    @DisplayName("로또 별로 맞은 개수에 따른 등수 계산하여 리스트로 저장")
    @Test
    void checkRankList() {
        assertThat(calculator.getResult()).isEqualTo(List.of(1, 1, 1, 1, 1));
    }

    @DisplayName("당첨 결과에 따른 수익률이 잘 계산되었는지 확인")
    @Test
    void checkRateOfReturn() {
        // 5개의 로또 중 4등 1개
        assertThat(calculator.getRateOfReturn(5000, List.of(0,0,0,1,0))).isEqualTo(200);
    }
}
