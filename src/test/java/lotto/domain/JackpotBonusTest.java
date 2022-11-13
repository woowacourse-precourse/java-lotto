package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

public class JackpotBonusTest {
    private static final JackpotBonus jackpotBonus= new JackpotBonus(List.of(1, 2, 3, 4, 5, 6), 7);
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberByDuplicateNumber() {
        List<Integer> jackpotNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {new JackpotBonus(jackpotNumbers, bonusNumber);});
    }
    @DisplayName("당첨 번호가 3개 미만으로 일치하면 -1을 반환한다")
    @Test
    void rank6By2Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        assertThat(jackpotBonus.getRankOf(lotto))
                .isEqualTo(-1);
    }

    @DisplayName("당첨 번호가 3개 일치하면 5를 반환한다")
    @Test
    void rank5By3Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        assertThat(jackpotBonus.getRankOf(lotto))
                .isEqualTo(5);
    }

    @DisplayName("당첨 번호와 4개 일치하면 4를 반환한다")
    @Test
    void rank4By4Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        assertThat(jackpotBonus.getRankOf(lotto))
                .isEqualTo(4);
    }

    @DisplayName("당첨 번호가 5개 일치하면 3을 반환한다")
    @Test
    void rank3By5Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        assertThat(jackpotBonus.getRankOf(lotto))
                .isEqualTo(3);
    }

    @DisplayName("당첨 번호가 5개 일치하고 보너스 번호가 일치하면 2를 반환한다")
    @Test
    void rank2By5JackpotAndBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(jackpotBonus.getRankOf(lotto))
                .isEqualTo(2);
    }

    @DisplayName("당첨 번호가 6개 일치하면 1을 반환한다")
    @Test
    void rank1By6Jackpot() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(jackpotBonus.getRankOf(lotto))
                .isEqualTo(1);
    }
}
