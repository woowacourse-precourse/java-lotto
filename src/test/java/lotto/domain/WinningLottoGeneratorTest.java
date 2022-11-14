package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoGeneratorTest {
    @DisplayName("입력값의 수가 부족한 경우 오류 반환")
    @Test
    void givenLackNumbers_whenCreateWinningLotto_thenThrowError() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Integer bonus = 13;

        //when//then
        assertThatThrownBy(() -> WinningLottoGenerator.generateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값의 수가 너무 많은 경우 오류 반환")
    @Test
    void givenToManyNumbers_whenCreateWinningLotto_thenThrowError() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7, 8));
        Integer bonus = 13;

        //when//then
        assertThatThrownBy(() -> WinningLottoGenerator.generateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 값과 일반 번호 중 중복되는 값이 주어지면 오류 반환")
    @Test
    void givenDuplicateNumber_whenCreateWinningLotto_thenThrowError() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        Integer bonus = 7;

        //when//then
        assertThatThrownBy(() -> WinningLottoGenerator.generateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("일반 당첨 번호에 중복되는 값이 주어지면 오류 반환")
    @Test
    void givenDuplicateNumberInNormalNumbers_whenCreateWinningLotto_thenThrowError() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        Integer bonus = 6;

        //when//then
        assertThatThrownBy(() -> WinningLottoGenerator.generateWinningLotto(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 주어지면 Winning Lotto를 생성한다")
    @Test
    void givenInput_whenCreateWinningLotto_thenReturnInstance() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 13;

        //when//then
        assertThat(WinningLottoGenerator.generateWinningLotto(numbers, bonus))
                .isInstanceOf(WinningLotto.class);
    }
}