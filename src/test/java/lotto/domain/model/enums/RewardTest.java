package lotto.domain.model.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;
import lotto.domain.model.request.LottoNumberRequest;
import lotto.domain.model.request.LottoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardTest {

    private static final List<Integer> TEST_WINNING_LOTTO = List.of(1, 2, 3, 4, 5, 6);
    private static final int TEST_BONUS_NUMBER = 7;

    private WinningLotto winningLotto;

    @BeforeEach
    void SETTING() {
        LottoRequest lottoRequest = new LottoRequest(TEST_WINNING_LOTTO);
        LottoNumberRequest lottoNumberRequest = new LottoNumberRequest(TEST_BONUS_NUMBER);
        winningLotto = new WinningLotto(lottoRequest, lottoNumberRequest);
    }

    @Test
    @DisplayName("1등이 Rank 되는지 확인 ")
    void FIRST_REWARD_TEST() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Reward reward = Reward.getRank(winningLotto, lotto);

        assertAll(
                () -> assertThat(reward.getCorrectCount()).isEqualTo(6),
                () -> assertThat(reward).isEqualTo(Reward.FIRST)
        );
    }

    @Test
    @DisplayName("2등이 Rank 되는지 확인 ")
    void SECOND_REWARD_TEST() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Reward reward = Reward.getRank(winningLotto, lotto);

        assertAll(
                () -> assertThat(reward.getCorrectCount()).isEqualTo(5),
                () -> assertThat(reward).isEqualTo(Reward.SECOND),
                () -> assertThat(reward.isHasBonusNumber()).isEqualTo(true)
        );
    }

    @Test
    @DisplayName("3등이 Rank 되는지 확인 ")
    void THIRD_REWARD_TEST() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 20));
        Reward reward = Reward.getRank(winningLotto, lotto);
        System.out.println(reward);

        assertAll(
                () -> assertThat(reward.getCorrectCount()).isEqualTo(5),
                () -> assertThat(reward).isEqualTo(Reward.THIRD)
        );
    }

    @Test
    @DisplayName("4등이 Rank 되는지 확인 ")
    void FOURTH_REWARD_TEST() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 20));
        Reward reward = Reward.getRank(winningLotto, lotto);

        assertAll(
                () -> assertThat(reward.getCorrectCount()).isEqualTo(4),
                () -> assertThat(reward).isEqualTo(Reward.FOURTH)
        );
    }

    @Test
    @DisplayName("5등이 Rank 되는지 확인 ")
    void FIFTH() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 12, 11, 10));
        Reward reward = Reward.getRank(winningLotto, lotto);

        assertAll(
                () -> assertThat(reward.getCorrectCount()).isEqualTo(3),
                () -> assertThat(reward).isEqualTo(Reward.FIFTH)
        );
    }
}