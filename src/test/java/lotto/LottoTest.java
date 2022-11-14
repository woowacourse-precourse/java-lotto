package lotto;

import static lotto.domain.Lotto.createLotto;
import static lotto.domain.LottoRank.getRankResult;
import static lotto.view.BonusInput.bonus;
import static lotto.view.BonusInput.bonusInput;
import static lotto.view.BonusInput.getBonusResult;
import static lotto.view.WinningInput.getWinningResult;
import static lotto.view.WinningInput.winningCount;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.LottoRank;
import lotto.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {
    private final Lotto lotto = createLotto();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 메서드는 6개의 번호를 생성")
    @Test
    void createLottoTestSize() {
        assertThat(lotto.getNumbers().size() == 6).isTrue();
    }

    @DisplayName("로또 생성 메서드는 1~45 범위의 숫자를 생성")
    @Test
    void createLottoTestByRange() {
        List<Integer> number = lotto.getNumbers();
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            assertThat(number.get(i) > 0 && number.get(i) < 46).isTrue();
        }
    }

    @DisplayName("로또 번호와 일치하는 숫자 개수를 카운팅")
    @Test
    void getWinningResultTest() {
        getWinningResult(List.of(List.of(8, 21, 23, 41, 42, 43), List.of(3, 5, 11, 16, 32, 38)),
                List.of(8, 21, 23, 30, 32, 38));
        assertThat(winningCount == 3).isTrue();
    }

    @DisplayName("로또 번호와 일치하는 보너스 번호가 있는지 확인")
    @Test
    void getBonusResultTest() {
        bonusInput = "21";
        getBonusResult(List.of(List.of(8, 21, 23, 41, 42, 43), List.of(3, 5, 11, 16, 32, 38)));
        assertThat(bonus).isTrue();
    }

    @DisplayName("당첨 개수와 적절한 메시지를 출력하는지 확인")
    @Test
    void getRankResultTest() {
        assertEquals(getRankResult(5, true).getMessage(), LottoRank.FIVE_BONUS_MATCHES.getMessage());
        assertEquals(getRankResult(5, false).getMessage(), LottoRank.FIVE_MATCHES.getMessage());
        assertEquals(getRankResult(4, false).getMessage(), LottoRank.FOUR_MATCHES.getMessage());
        assertEquals(getRankResult(3, true).getMessage(), LottoRank.THREE_MATCHES.getMessage());
        assertEquals(getRankResult(0, true).getMessage(), LottoRank.NONE_MATCH.getMessage());
    }
}
