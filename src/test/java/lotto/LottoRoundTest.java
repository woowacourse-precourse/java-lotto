package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRoundTest {

    @DisplayName("로또 회차의 보너스 번호는 1 ~ 45 범위여야 한다.")
    @Test
    void createLottoRoundByOverRangeBonusNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 47;

        assertThatThrownBy(() -> new LottoRound(winningNum, bonusNums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 회차의 보너스 번호는 당첨번호와 중복될 수 없다.")
    @Test
    void createLottoRoundByByDuplicateWithBonusNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 5;

        assertThatThrownBy(() -> new LottoRound(winningNum, bonusNums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 3개 미만 일치할 경우 LOSE.")
    @Test
    void compareByLoseNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoRound lottoRound = new LottoRound(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        assertThat(lottoRound.getRank(loseNum)).isEqualTo(LottoRank.LOSE);
    }

    @DisplayName("당첨번호와 3개 일치할 경우 5등.")
    @Test
    void compareByFifthPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoRound lottoRound = new LottoRound(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(5, 6, 1, 8, 9, 10));
        assertThat(lottoRound.getRank(loseNum)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("당첨번호와 4개 일치할 경우 4등.")
    @Test
    void compareByFourthPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoRound lottoRound = new LottoRound(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(1, 3, 5, 6, 9, 10));
        assertThat(lottoRound.getRank(loseNum)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("당첨번호와 5개 일치하고 보너스 번호 미일치할 경우 3등.")
    @Test
    void compareByThirdPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoRound lottoRound = new LottoRound(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(1, 3, 4, 5, 6, 12));
        assertThat(lottoRound.getRank(loseNum)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("당첨번호와 5개 일치하고 보너스 번호 일치할 경우 2등.")
    @Test
    void compareBySecondPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoRound lottoRound = new LottoRound(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(1, 3, 4, 5, 6, 10));
        assertThat(lottoRound.getRank(loseNum)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("당첨번호와 5개 일치하고 보너스 번호 미일치할 경우 3등.")
    @Test
    void compareByFirstPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoRound lottoRound = new LottoRound(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoRound.getRank(loseNum)).isEqualTo(LottoRank.FIRST);
    }
}
