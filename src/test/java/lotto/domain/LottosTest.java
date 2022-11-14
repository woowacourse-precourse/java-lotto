package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {
    Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(7, 8, 9, 10, 11, 12))));

    @Test
    void 로또_4등_당첨_한_개_꽝() {
        //given
        Lotto winningLotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        BonusNumber bonusNumber = new BonusNumber("9");

        //when
        LottoResults expectedLottoResults = lottos.compareToLottoNumbers(winningLotto, bonusNumber);
        LottoResults actualLottoResults = new LottoResults(List.of(LottoRank.FOURTH, LottoRank.NONE));

        //then
        Assertions.assertThat(expectedLottoResults).isEqualTo(actualLottoResults);
    }

    @Test
    void 로또_당첨_한_개_꽝() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("7");

        //when
        LottoResults expectedLottoResults = lottos.compareToLottoNumbers(winningLotto, bonusNumber);
        LottoResults actualLottoResults = new LottoResults(List.of(LottoRank.FIRST, LottoRank.NONE));

        //then
        Assertions.assertThat(expectedLottoResults).isEqualTo(actualLottoResults);
    }
}