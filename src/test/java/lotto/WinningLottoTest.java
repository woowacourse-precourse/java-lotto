package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    private Lotto winningNumbers;
    private List<Lotto> userMultipleLotto;
    private String bounusNumber;

    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bounusNumber = "7";
        userMultipleLotto = new ArrayList<>();
        userMultipleLotto.add(new Lotto(List.of(1, 2, 3, 40, 41, 42)));
        userMultipleLotto.add(new Lotto(List.of(1, 2, 3, 4, 41, 42)));
        userMultipleLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
    }

    @DisplayName("보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void inputBonusNumberNotNumeric() {
        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, "a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 WinningNumbers와 중복된다면 예외가 발생한다.")
    @Test
    void inputDuplicateBonusNumber() {
        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Rank의 매치 개수 조건에 맞게 카운트한다.")
    @Test
    void getUserLottoScoreByWinningLotto() {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bounusNumber);
        Map<Rank, Integer> userLottoScore = winningLotto.getUserLottoScore(userMultipleLotto);
        assertThat(userLottoScore.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(userLottoScore.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(userLottoScore.get(Rank.SECOND)).isEqualTo(1);
        assertThat(userLottoScore.get(Rank.THIRD)).isEqualTo(0);
        assertThat(userLottoScore.get(Rank.FIRST)).isEqualTo(0);
    }
}
