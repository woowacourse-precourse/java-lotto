package lotto;

import lotto.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static lotto.type.Rank.RANK_FOUR;
import static lotto.type.Rank.RANK_TWO;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("로또 당첨결과를 계산한다.")
    @Test
    void calculateResult() {
        //given
        Lotto winningLotto = new Lotto(Arrays.asList(15, 16, 18, 25, 37, 45));
        Lotto correct4Lotto = new Lotto(Arrays.asList(15, 18, 26, 1, 37, 45));
        Lotto correct5andBonusLotto = new Lotto(Arrays.asList(16, 15, 7, 25, 37, 45));
        List<Lotto> goingToPublish = Arrays.asList(correct4Lotto, correct5andBonusLotto);
        LottoGame game = new LottoGame(7, winningLotto, goingToPublish);

        EnumMap<Rank, Integer> expectRanks = new EnumMap<>(Rank.class);
        expectRanks.put(RANK_FOUR, 1);
        expectRanks.put(RANK_TWO, 1);
        LottoResult expectResult = new LottoResult(expectRanks);

        //when
        LottoResult result = game.generateResult();

        //then
        assertThat(result.ranks).isEqualTo(expectResult.ranks);
    }
}