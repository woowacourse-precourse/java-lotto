package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중복 검사 테스트")
    @Test
    void 로또_번호_중복_검사() {

        Domain domain = new Domain();
        List<String> input = Arrays.asList("1", "2", "3", "4", "5", "5");

        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validateOverlapping(input);
        });
    }

    @DisplayName("로또 번호 중복 검사 테스트: 중복 없을 때")
    @Test
    void 로또_번호_중복_검사2() {
        Domain domain = new Domain();
        List<String> input = Arrays.asList("1", "2", "3", "4", "5", "6");

        domain.validateOverlapping(input);
    }

    @DisplayName("getNumberOfOverlapping 기능 테스트")
    @Test
    void 겹치는_개수에_따른_반환() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = Arrays.asList(7, 8, 9, 10, 11, 12, 13);

        assertThat(lotto.getNumberOfOverlapping(numbers) ==  0);
        numbers = Arrays.asList(1, 8, 9, 10, 11, 12);
        assertThat(lotto.getNumberOfOverlapping(numbers) ==  1);
        numbers = Arrays.asList(1, 2, 9, 10, 11, 12);
        assertThat(lotto.getNumberOfOverlapping(numbers) ==  2);
        numbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        assertThat(lotto.getNumberOfOverlapping(numbers) ==  3);
        numbers = Arrays.asList(1, 2, 3, 4, 11, 12);
        assertThat(lotto.getNumberOfOverlapping(numbers) ==  4);
        numbers = Arrays.asList(1, 2, 3, 4, 5, 12);
        assertThat(lotto.getNumberOfOverlapping(numbers) ==  5);
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getNumberOfOverlapping(numbers) ==  6);
    }

    @DisplayName("getRank 기능 테스트")
    @Test
    void 겹치는_개수에_따른_등수_반환() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        int bonus = -1;

        assertThat(lotto.getRank(numbers, bonus) ==  8);
        numbers = Arrays.asList(1, 8, 9, 10, 11, 12);
        assertThat(lotto.getRank(numbers, bonus) ==  7);
        numbers = Arrays.asList(1, 2, 9, 10, 11, 12);
        assertThat(lotto.getRank(numbers, bonus) ==  6);
        numbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        assertThat(lotto.getRank(numbers, bonus) ==  5);
        numbers = Arrays.asList(1, 2, 3, 4, 11, 12);
        assertThat(lotto.getRank(numbers, bonus) ==  4);
        numbers = Arrays.asList(1, 2, 3, 4, 5, 12);
        assertThat(lotto.getRank(numbers, bonus) ==  3);
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getRank(numbers, bonus) ==  1);

        bonus = 7;
        numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        assertThat(lotto.getRank(numbers, bonus) ==  2);
    }
}