package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호는 오름차순으로 정렬이 되어 있어야한다.")
    @Test
    void createLottoByOrdered() throws Exception {
        List question = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            question.add(i + 1);
        }
        Lotto lotto = new Lotto(question);

        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        Field privateField = lotto.getClass().getDeclaredField("numbers");
        privateField.setAccessible(true);
        List<Integer> numbers = (List<Integer>) privateField.get(lotto);

        assertThat(numbers).isEqualTo(result);
    }
}
