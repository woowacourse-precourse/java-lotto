package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {

    static Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
    static int bonusNumber = 7;
    static LottoChecker lottoChecker = new LottoChecker(winningLotto, bonusNumber);

    @Test
    void 로또_1등(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6))
        );

        List<LottoReward> calculate = lottoChecker.calculate(lottos);

        assertThat(calculate.get(0)).isEqualTo(LottoReward.FIRST);
    }

    @Test
    void 로또_2등(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,7))
        );
        List<LottoReward> calculate = lottoChecker.calculate(lottos);

        assertThat(calculate.get(0)).isEqualTo(LottoReward.SECOND);
    }

    @Test
    void 로또_3등(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,11))
        );
        List<LottoReward> calculate = lottoChecker.calculate(lottos);

        assertThat(calculate.get(0)).isEqualTo(LottoReward.THIRD);
    }

    @Test
    void 로또_4등(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,11,12))
        );
        List<LottoReward> calculate = lottoChecker.calculate(lottos);

        assertThat(calculate.get(0)).isEqualTo(LottoReward.FOURTH);
    }

    @Test
    void 로또_5등(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,11,12,13))
        );
        List<LottoReward> calculate = lottoChecker.calculate(lottos);

        assertThat(calculate.get(0)).isEqualTo(LottoReward.FIFTH);
    }

    @Test
    void 로또_꽝(){
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,10,9,25,34))
        );
        List<LottoReward> calculate = lottoChecker.calculate(lottos);

        assertThat(calculate.get(0)).isEqualTo(LottoReward.EMPTY);
    }
}