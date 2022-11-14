package lotto.vo;

import lotto.system.validator.ConvertingToLottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Lotto 테스트")
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

    // 아래에 추가 테스트 작성 가능

    @Test
    @DisplayName("유효한 로또 번호로 Lotto 객체를 만들 수 있다.")
    void givenNumbers_whenCreatingLotto_thenSuccess() {
        //given
        List<Integer> numbers = Arrays.asList(2, 4, 5, 16, 42, 45);

        //when && then
        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("1~45 범위를 벗어나는 로또 번호로 Lotto 객체를 만드려 하면 예외가 발생한다.")
    void givenNumbersWithInvalidNumberRange_whenCreatingLotto_thenThrowsException() {
        //given
        List<Integer> numbers = Arrays.asList(2, 4, 5, 42, 45, 47);

        //when && then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ConvertingToLottoValidator.INVALID_NUMBER_RANGE_MESSAGE);
    }

    @Test
    @DisplayName("오름차순 정렬되어있지 않은 로또 번호로 Lotto 객체를 만들면, 만들어진 객체 내부의 로또 번호는 오름차순으로 정렬이 되어있다.")
    void givenNumbersNotSortedAsc_whenCreatingLotto_thenThrowsException() {
        //given
        List<Integer> given = Arrays.asList(2, 4, 42, 11, 23, 44);
        List<Integer> orderedNumbers = new ArrayList<>(given);
        Collections.sort(orderedNumbers);

        assertThat(given)
                .as("주어진 리스트는 오름차순 정렬이 안 되어있다.")
                .isNotEqualTo(orderedNumbers);

        //when
        Lotto target = new Lotto(given);

        //then
        assertThat(target.getNumbers())
                .as("검증 과정을 거친 후에는 오름차순 정렬이 되어 있다.")
                .isEqualTo(orderedNumbers);
    }
}
