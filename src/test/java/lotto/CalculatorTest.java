package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;


class CalculatorTest {

    private int bonusNumber;
    private Lotto winningLotto;
    private List<Lotto> lottoList = new ArrayList<>();

    private Calculator calculator;

    @BeforeEach
    void init() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;

        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 9)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 9, 10)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 10, 11, 12)));
        calculator = new Calculator(winningLotto, lottoList, bonusNumber);
    }


    @DisplayName("당첨 기록 생성")
    @Test
    public void createHistoryTest() {
        HashMap<Rank, Integer> history = calculator.getHistory();

        //history의 size 검사
        Assertions.assertThat(history.size()).isEqualTo(5);

        //결과값 검증
        Set<Rank> keys = history.keySet();
        for (Rank rank : keys) {
            Assertions.assertThat(history.get(rank)).isEqualTo(1);
        }
    }

    @DisplayName("두 개의 로또를 비교해 몇 개의 숫자가 겹치는지 확인")
    @Test
    void compareWinningLottoWithPurchaseLottoTest() {
        Lotto purchaseLotto = new Lotto(List.of(2, 4, 6, 8, 10, 12));
        int result = calculator.compareWinningLottoWithPurchaseLotto(winningLotto, purchaseLotto);

        Assertions.assertThat(result).isEqualTo(3);
    }
}