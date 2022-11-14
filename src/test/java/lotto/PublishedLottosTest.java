package lotto;

import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.enums.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class PublishedLottosTest {

    @DisplayName("발행로또, 당첨로또, 보너스 번호를 비교해 당첨순위를 계산한다.")
    @Test
    void calculateResultRanks() {
        //given
        Integer bonusNumber = 45;
        Lotto winningLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        Lotto correct4Lotto = new Lotto(List.of(1, 3, 5, 6, 7, 8));
        Lotto nonCorrectLotto = new Lotto(List.of(31, 32, 33, 34, 35, 40));
        Lotto correct5AndBonusLotto = new Lotto(List.of(1, 3, 5, 7, 11, 45));
        List<Lotto> publishLottos = List.of(correct4Lotto, nonCorrectLotto, correct5AndBonusLotto);
        PublishedLottos publishedLottos = new PublishedLottos(winningLotto, publishLottos);

        //when
        List<Rank> rankResult = publishedLottos.calculateResultRanks(bonusNumber);

        //then
        assertThat(rankResult).isEqualTo(List.of(RANK_FOUR, RANK_NONE, RANK_TWO));
    }
}