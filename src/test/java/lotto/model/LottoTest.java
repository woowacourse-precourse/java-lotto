package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("유효하지 않은 로또 번호이라면 객체가 생성되지 않고 예외를 반환한다.")
    void checkLottoConstructorWithInvalidNumbers() {
        //given
        List<Integer> invalidNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        //when, then
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
