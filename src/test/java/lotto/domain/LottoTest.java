package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("랜덤으로 생성된 로또가 유효하지 않으면 예외가 발생한다.")
    @MethodSource("invalidLottoNumber")
    @ParameterizedTest(name = "{0} : {1}")
    void createLottoByOverSize(String situation, List<Integer> randomLottoNumber) {
        assertThatThrownBy(() -> new Lotto(randomLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호가 유효하지 않은 경우 예외가 발생한다.")
    @MethodSource("invalidWinningNumber")
    @ParameterizedTest(name = "{0} : {1}")
    void createLottoIncludedAlphabetNumber(String situation, String winningNumber) {
        assertThatThrownBy(() -> Lotto.from(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidLottoNumber() {
        return Stream.of(
                Arguments.of("숫자가 7개인 경우", List.of(1,2,3,4,5,6,7)),
                Arguments.of("숫자가 3개인 경우", List.of(1,2,3)),
                Arguments.of("중복된 숫자가 있는 경우", List.of(1,2,3,4,5,5)),
                Arguments.of("숫자가 45보다 큰 경우", List.of(1,2,3,4,5,50)),
                Arguments.of("숫자가 1보다 작은 경우", List.of(0,2,3,4,5,6))
        );
    }

    static Stream<Arguments> invalidWinningNumber() {
        return Stream.of(
                Arguments.of("숫자가 6개보다 많은 경우", "1,2,3,4,5,6,7"),
                Arguments.of("알파벳이 포함된 경우", "1,2,3,4,5,a"),
                Arguments.of("숫자 범위를 벗어난 경우", "1,2,3,4,5,50"),
                Arguments.of("한글이 들어간 경우", "ㄱ,ㄴ,ㄷ,ㄹ,ㅁ"),
                Arguments.of("공백인 경우", ""),
                Arguments.of("숫자가 적은 경우", "1,2,3")
        );
    }
}
