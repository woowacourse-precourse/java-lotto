package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
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
}