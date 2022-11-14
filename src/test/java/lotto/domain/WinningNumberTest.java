package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @Test
    @DisplayName("보너스 번호가 1보다 작거나 45보다 크면 예외 처리")
    void createBonusNumberByOutOfNumber() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_OUT_OF_RANGE.toString());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 처리")
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_DUPLICATION.toString());
    }

    @Test
    @DisplayName("당첨 번호와 로또 발행 번호 비교 - 1등")
    void checkLottoWithFirst() {
        int count = 1;
        List<Lotto> issueNumbers = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                )
        );
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        HashMap<Integer, Integer> result = winningNumber.checkLotto(issueNumbers);

        assertEquals(count, result.get(WinningNumberStatus.FIRST.getOrder()));
    }

    @Test
    @DisplayName("당첨 번호와 로또 발행 번호 비교 - 2등")
    void checkLottoWithSecond() {
        int count = 2;
        List<Lotto> issueNumbers = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 6, 7))
                )
        );
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        HashMap<Integer, Integer> result = winningNumber.checkLotto(issueNumbers);

        assertEquals(count, result.get(WinningNumberStatus.SECOND.getOrder()));
    }

    @Test
    @DisplayName("당첨 번호와 로또 발행 번호 비교 - 3등")
    void checkLottoWithThird() {
        int count = 3;
        List<Lotto> issueNumbers = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 6, 8)),
                        new Lotto(List.of(1, 2, 3, 5, 6, 8))
                )
        );
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        HashMap<Integer, Integer> result = winningNumber.checkLotto(issueNumbers);

        assertEquals(count, result.get(WinningNumberStatus.THIRD.getOrder()));
    }

    @Test
    @DisplayName("당첨 번호와 로또 발행 번호 비교 - 4등")
    void checkLottoWithFourth() {
        int count = 4;
        List<Lotto> issueNumbers = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                        new Lotto(List.of(1, 2, 3, 5, 7, 8)),
                        new Lotto(List.of(1, 2, 3, 6, 7, 8)),
                        new Lotto(List.of(1, 2, 4, 5, 7, 8))
                )
        );
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        HashMap<Integer, Integer> result = winningNumber.checkLotto(issueNumbers);

        assertEquals(count, result.get(WinningNumberStatus.FOURTH.getOrder()));
    }

    @Test
    @DisplayName("당첨 번호와 로또 발행 번호 비교 - 5등")
    void checkLottoWithFifth() {
        int count = 5;
        List<Lotto> issueNumbers = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                        new Lotto(List.of(1, 2, 4, 7, 8, 9)),
                        new Lotto(List.of(1, 2, 5, 7, 8, 9)),
                        new Lotto(List.of(1, 2, 6, 7, 8, 9)),
                        new Lotto(List.of(1, 3, 5, 7, 8, 9))
                )
        );
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        HashMap<Integer, Integer> result = winningNumber.checkLotto(issueNumbers);

        assertEquals(count, result.get(WinningNumberStatus.FIFTH.getOrder()));
    }
}