package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomLottoTest {
    @DisplayName("발행된 로또 중에 동일한 번호로 이루어진 것이 있다면 예외를 발생시킨다.")
    @Test
    void randomNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new RandomLotto(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행 로또 갯수만큼 로또의 번호를 생성한다.")
    @Test
    void wrongOfLottoAmount() {
        int ticket = 5;
        List<List<Integer>> numbers = RandomLotto.creatRandomNumber(ticket);
        assertThat(numbers.size()).isEqualTo(5);
    }
}
