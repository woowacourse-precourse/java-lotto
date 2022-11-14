package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRecordTest {
    @DisplayName("구매한 가격 대비 수익률은 0.0 퍼센트보다 커야한다.")
    @ParameterizedTest(name = "로또 수익률 테스트[{index}] -> {0}원을 넣으면 수익률이 0.0% 보단 커야한다.")
    @ValueSource(ints = {2000, 100000, 5000, 6000, 20000, 90000, 80000, 6000})
    void yeildIsGreaterThanOrEqualToZero(int source) {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.publish(source);
        lottoMachine.setLuckyNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        WinningRecord winningRecord = lottoMachine.drawAll(lottos);
        double actual = winningRecord.getYield();
        assertThat(actual).isGreaterThanOrEqualTo(0.0);
    }
}