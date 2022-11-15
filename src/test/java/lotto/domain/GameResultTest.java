package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void init() {
        gameResult = new GameResult();
    }

    @DisplayName("6개가 일치하면 1등을 한다.")
    @Test
    void WinFirstPlaceIfSixNumbersAreMatched() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto));
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        gameResult.calculateTotalResult(lottos, winningNumber, bonusNumber);
        List<Integer> result = gameResult.getResult();

        assertThat(result).isEqualTo(List.of(0, 1, 0, 0, 0, 0));
    }

    @DisplayName("5개와 보너스 숫자가 일치하면 2등을 한다.")
    @Test
    void WinSecondPlaceIfFiveNumbersAndBonusNumberAreMatched() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto));
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 6;

        gameResult.calculateTotalResult(lottos, winningNumber, bonusNumber);
        List<Integer> result = gameResult.getResult();

        assertThat(result).isEqualTo(List.of(0, 0, 1, 0, 0, 0));
    }

    @DisplayName("5개가 일치하면 3등을 한다.")
    @Test
    void WinThirdPlaceIfFiveNumbersAreMatched() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto));
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 8;

        gameResult.calculateTotalResult(lottos, winningNumber, bonusNumber);
        List<Integer> result = gameResult.getResult();

        assertThat(result).isEqualTo(List.of(0, 0, 0, 1, 0, 0));
    }

    @DisplayName("4개가 일치하면 4등을 한다.")
    @Test
    void WinFourthPlaceIfFourNumbersAreMatched() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto));
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 7, 8));
        int bonusNumber = 9;

        gameResult.calculateTotalResult(lottos, winningNumber, bonusNumber);
        List<Integer> result = gameResult.getResult();

        assertThat(result).isEqualTo(List.of(0, 0, 0, 0, 1, 0));
    }
}
