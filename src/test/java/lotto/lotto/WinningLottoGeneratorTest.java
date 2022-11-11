package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoGeneratorTest {
    @DisplayName("입력값의 수가 부족한 경우 오류 반환")
    @Test
    void givenLackNumbers_whenCreateWinningLotto_thenThrowError() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5));
        Integer bonus = 13;

        //when//then
        assertThatThrownBy(() -> WinningLottoGenerator.generateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값의 수가 너무 많은 경우 오류 반환")
    @Test
    void givenToManyNumbers_whenCreateWinningLotto_thenThrowError() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,7,8));
        Integer bonus = 13;

        //when//then
        assertThatThrownBy(() -> WinningLottoGenerator.generateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 주어지면 Winning Lotto를 생성한다")
    @Test
    void givenInput_whenCreateWinningLotto_thenReturnInstance() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        Integer bonus = 13;

        //when//then
        assertThat(WinningLottoGenerator.generateWinningLotto(numbers, bonus))
                .isInstanceOf(WinningLotto.class);
    }
}