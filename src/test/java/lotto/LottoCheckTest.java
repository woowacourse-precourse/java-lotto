package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckTest {

    void createLottoCheckByOverRangeBonusNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 47;

        assertThatThrownBy(() -> new LottoCheck(winningNum, bonusNums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    void createLottoCheckByByDuplicateWithBonusNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 5;

        assertThatThrownBy(() -> new LottoCheck(winningNum, bonusNums))
                .isInstanceOf(IllegalArgumentException.class);
    }

    void compareByLoseNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoCheck lottoCheck = new LottoCheck(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        assertThat(lottoCheck.getRank(loseNum)).isEqualTo(LottoRank.LOSE);
    }

    void compareByFifthPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoCheck lottoCheck = new LottoCheck(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(5, 6, 1, 8, 9, 10));
        assertThat(lottoCheck.getRank(loseNum)).isEqualTo(LottoRank.FIFTH);
    }

    void compareByFourthPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoCheck lottoCheck = new LottoCheck(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(1, 3, 5, 6, 9, 10));
        assertThat(lottoCheck.getRank(loseNum)).isEqualTo(LottoRank.FOURTH);
    }

    void compareByThirdPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoCheck lottoCheck = new LottoCheck(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(1, 3, 4, 5, 6, 12));
        assertThat(lottoCheck.getRank(loseNum)).isEqualTo(LottoRank.THIRD);
    }

    void compareBySecondPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoCheck lottoCheck = new LottoCheck(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(1, 3, 4, 5, 6, 10));
        assertThat(lottoCheck.getRank(loseNum)).isEqualTo(LottoRank.SECOND);
    }

    void compareByFirstPlaceNumber() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNums = 10;
        LottoCheck lottoCheck = new LottoCheck(winningNum, bonusNums);

        Lotto loseNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoCheck.getRank(loseNum)).isEqualTo(LottoRank.FIRST);
    }
}