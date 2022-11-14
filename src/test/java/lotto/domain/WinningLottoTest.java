package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("중복되는 숫자가 있을 경우 오류 반환")
    @Test
    void givenLackOfLottoNumber_whenCreateWinningLotto_thenThrowError() {
        //given
        Map<Integer, Boolean> winningNumbers = new HashMap<>();
        winningNumbers.put(1, false);
        winningNumbers.put(2, false);
        winningNumbers.put(3, false);
        winningNumbers.put(4, false);
        winningNumbers.put(5, false);
        winningNumbers.put(1, false);
        winningNumbers.put(7, true);
        //when //then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("허용하는 최대값 초과인 번호가 있으면 예외가 발생한다.")
    @Test
    void givenLargerThanUpperBound_whenCreateWinningLotto_thenThrowError() {
        //given
        Map<Integer, Boolean> winningNumbers = new HashMap<>();
        winningNumbers.put(1, false);
        winningNumbers.put(2, false);
        winningNumbers.put(3, false);
        winningNumbers.put(4, false);
        winningNumbers.put(5, false);
        winningNumbers.put(46, false);
        winningNumbers.put(7, true);
        //when //then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("허용하는 최소값 미만인 번호가 있으면 예외가 발생한다.")
    @Test
    void givenLessThanLowerBound_whenCreateWinningLotto_thenThrowError() {
        //given
        Map<Integer, Boolean> winningNumbers = new HashMap<>();
        winningNumbers.put(1, false);
        winningNumbers.put(2, false);
        winningNumbers.put(3, false);
        winningNumbers.put(4, false);
        winningNumbers.put(5, false);
        winningNumbers.put(6, false);
        winningNumbers.put(0, true);
        //when //then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("조건을 모두 만족하는 경우 인스턴스를 반환한다.")
    @Test
    void givenValidNumbers_whenCreateWinningLotto_thenReturnInstance() {
        //given
        Map<Integer, Boolean> winningNumbers = new HashMap<>();
        winningNumbers.put(1, false);
        winningNumbers.put(2, false);
        winningNumbers.put(3, false);
        winningNumbers.put(4, false);
        winningNumbers.put(5, false);
        winningNumbers.put(6, false);
        winningNumbers.put(7, true);

        //when //then
        assertThat(new WinningLotto(winningNumbers))
                .isInstanceOf(WinningLotto.class);
    }

    @DisplayName("모든 번호가 다 맞은 경우 그 count를 반환한다.")
    @Test
    void givenAllMatchedNumber_whenCountMatchWithWinningNumber_thenReturnResult() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Map<Integer, Boolean> winningNumber = new HashMap<>();
        winningNumber.put(1, false);
        winningNumber.put(2, false);
        winningNumber.put(3, false);
        winningNumber.put(4, false);
        winningNumber.put(5, false);
        winningNumber.put(6, false);
        winningNumber.put(7, true);
        WinningLotto winningLotto = WinningLotto.of(winningNumber);

        //when
        LottoResult result = winningLotto.compare(numbers);

        //then
        assertThat(result.getBonusCount()).isEqualTo(0);
        assertThat(result.getNormalCount()).isEqualTo(6);
    }

    @DisplayName("보너스 1개, 일반번호 4개 맞은 경우 그 count를 반환한다.")
    @Test
    void givenMatchedNumber_whenCountMatchWithWinningNumber_thenReturnResult() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Map<Integer, Boolean> winningNumber = new HashMap<>();
        winningNumber.put(1, false);
        winningNumber.put(2, false);
        winningNumber.put(3, false);
        winningNumber.put(4, false);
        winningNumber.put(7, false);
        winningNumber.put(8, false);
        winningNumber.put(6, true);
        WinningLotto winningLotto = WinningLotto.of(winningNumber);

        //when
        LottoResult result = winningLotto.compare(numbers);

        //then
        assertThat(result.getBonusCount()).isEqualTo(1);
        assertThat(result.getNormalCount()).isEqualTo(4);
    }

    @DisplayName("일치하는 숫자가 하나도 없는 경우 그 count를 반환한다.")
    @Test
    void givenNothingMatchedNumber_whenCountMatchWithWinningNumber_thenReturnResult() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(11, 12, 13, 14, 15, 16));
        Map<Integer, Boolean> winningNumber = new HashMap<>();
        winningNumber.put(1, false);
        winningNumber.put(2, false);
        winningNumber.put(3, false);
        winningNumber.put(4, false);
        winningNumber.put(7, false);
        winningNumber.put(8, false);
        winningNumber.put(6, true);
        WinningLotto winningLotto = WinningLotto.of(winningNumber);

        //when
        LottoResult result = winningLotto.compare(numbers);

        //then
        assertThat(result.getBonusCount()).isEqualTo(0);
        assertThat(result.getNormalCount()).isEqualTo(0);
    }
}