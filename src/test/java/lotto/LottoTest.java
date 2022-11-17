package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    static Stream<Arguments> setLottoNumbers() {
        return Stream.of(
                Arguments.arguments(new ArrayList<String>(List.of("12", "3", "4", "5", "9.3", "8"))),
                Arguments.arguments(new ArrayList<String>(List.of("12", "3", "4", "5", "7", "8a"))),
                Arguments.arguments(new ArrayList<String>(List.of("12", "-3", "4", "5", "9", "8")))
        );
    }

    @DisplayName("로또 번호에 양의 정수 이외의 수가 있으면 예외가 발생한다.")
    @MethodSource("setLottoNumbers")
    @ParameterizedTest(name = "{index}. {0}")
    void createLottoByOtherWords(List<String> numbers) {
        assertThatThrownBy(() -> Lotto.validateLottoIsNumeric(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 56)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
