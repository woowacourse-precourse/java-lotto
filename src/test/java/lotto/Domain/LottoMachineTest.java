package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("구입 금액을 입력하면 발행 개수로 바꿔준다.")
    @Test
    void makeLottoCountByMoney() {
        int amount = lottoMachine.calculateAmount("8000");
        assertThat(amount).isEqualTo(8);
    }

    @DisplayName("구입한 로또와 당첨 번호를 비교해서 맞은 개수를 반환해준다.")
    @Test
    void compareLotto() {
        int bingo = lottoMachine.calculateBingo(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 11, 12, 13)));
        assertThat(bingo).isEqualTo(3);
    }

    @DisplayName("발행 개수 만큼 로또를 발행해서 반환해준다.")
    @Test
    void issuedByTheNumber() {
        List<Lotto> lottos = lottoMachine.publishLotto(7);
        assertThat(lottos.size()).isEqualTo(7);
    }

    @DisplayName("당첨 번호를 쉼표를 기준으로 구분해서 로또를 만들어준다.")
    @Test
    void makeLotto() {
        Lotto lotto = lottoMachine.calculateWinningNumber("1,2,3,4,5,6");
        assertThat(lotto.isContain(1)).isTrue();
        assertThat(lotto.isContain(2)).isTrue();
        assertThat(lotto.isContain(3)).isTrue();
        assertThat(lotto.isContain(4)).isTrue();
        assertThat(lotto.isContain(5)).isTrue();
        assertThat(lotto.isContain(6)).isTrue();
        assertThat(lotto.isContain(7)).isFalse();
    }

    @DisplayName("당첨 결과를 계산해준다.")
    @Test
    void calculateResult() {
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 11)),
                new Lotto(List.of(1, 2, 3, 4, 20, 21)),
                new Lotto(List.of(1, 2, 10, 11, 12, 45)
                )));

        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 10;
        Map<Reward, Integer> result = lottoMachine.calculateResult(lottos, winning, bonus);
        assertThat(result.get(Reward.FIRST)).isEqualTo(1);
        assertThat(result.get(Reward.SECOND)).isEqualTo(1);
        assertThat(result.get(Reward.THIRD)).isEqualTo(1);
        assertThat(result.get(Reward.FOURTH)).isEqualTo(1);
        assertThat(result.get(Reward.FIFTH)).isEqualTo(0);

    }
}