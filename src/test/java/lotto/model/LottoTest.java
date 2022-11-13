package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    private List<Integer> numbers;
    private Lotto testLotto;

    void setUp() {
        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        testLotto = new Lotto(numbers);
    }

    @Test
    @DisplayName("유효하지 않은 로또 번호이라면 객체가 생성되지 않고 예외를 반환한다.")
    void checkLottoConstructorWithInvalidNumbers() {
        //given
        List<Integer> invalidNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        //when, then
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("특정 숫자가 포함되어있는지 여부를 올바르게 반환한다.")
    void checkIsContain() {
        //given
        setUp();
        int compareNumber = 3;

        //when
        boolean result = testLotto.isContain(compareNumber);

        //then
        assertThat(result).isEqualTo(true);
    }
}
