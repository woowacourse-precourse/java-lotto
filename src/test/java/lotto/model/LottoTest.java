package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

    @ParameterizedTest(name = "규칙을 준수한 문자열을 통해 로또 번호를 생성한다.")
    @ValueSource(strings = {
            "1,2,3,4,5,6",
            "40,41,42,43,44,45"
    })
    void createLottoByValidString(String input) {
        assertDoesNotThrow(() -> Lotto.from(input));
    }

    @ParameterizedTest(name = "규칙을 준수하지 않은 문자열을 통해 로또 번호를 생성한다.")
    @ValueSource(strings = {
            "1,2,3",
            "-1,-2,-3,-4,-5,-6",
            "가나다",
            "가,나,다,라,마,바",
            "47, 2, 54, 3, 1, 6",
    })
    void createLottoByInvalidString(String input) {
        assertThatThrownBy(() -> Lotto.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 랜덤으로 생성한다.")
    @Test
    void createLottoByRandomNumbers() {
        assertDoesNotThrow(Lotto::fromRandomNumbers);
    }

    @DisplayName("문자열로 반환 한다")
    @Test
    void toStringFromLotto() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("")
    @Test
    void retainAll() {

    }

    @DisplayName("")
    @Test
    void contains() {

    }
}
