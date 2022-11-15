package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private enum input_example{
        OverSize(List.of(1, 2, 3, 4, 5, 6, 7)),
        Duplicated(List.of(1, 2, 3, 4, 5, 6, 7)),
        OverNumber(List.of(1, 2, 3, 48, 5, 6, 7));
        private final List<Integer> table_value;

        input_example(List<Integer> table_value){
            this.table_value = table_value;
        }
        public List<Integer> getValue() {return table_value;}
    }

    @DisplayName("로또 번호의 개수가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(input_example.OverSize.getValue()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(input_example.Duplicated.getValue()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 0 ~ 45 이외의 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverNumber() {
        assertThatThrownBy(() -> new Lotto(input_example.OverNumber.getValue()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
