package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
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

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다..")
    @Test
    void givenlackOfLottoNumber_whencreateLotto_thenThrowError() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 최소값 미만인 번호가 있으면 예외가 발생한다.")
    @Test
    void givenGreaterThanUpperBound_whenCreateLotto_thenThrowError() {
        //given
        List<Integer> numberInput = List.of(0, 2, 3, 4, 5, 44);

        //when
        Throwable thrown = catchThrowable(() -> new Lotto(numberInput));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 최대값 초과인 번호가 있으면 예외가 발생한다.")
    @Test
    void givenLessThanLowerBound_whenCreateLotto_thenThrowError() {
        //given
        List<Integer> numberInput = List.of(1, 2, 3, 4, 5, 46);

        //when
        Throwable thrown = catchThrowable(() -> new Lotto(numberInput));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 조건을 만족할 경우 Lotto Instance를 반환한다.")
    @Test
    void givenValidNumber_whenCreateLotto_thenReturnLottoInstance() {
       //given
        List<Integer> numberInput = List.of(1, 2, 3, 4, 5, 45);

        //when //then
        assertThat(new Lotto(numberInput)).isInstanceOf(Lotto.class);
    }
}
