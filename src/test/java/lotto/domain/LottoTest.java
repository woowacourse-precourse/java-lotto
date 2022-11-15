package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("랜덤으로 생성된 로또가 유효하지 않으면 예외가 발생한다.")
    @MethodSource("invalidLottoNumber")
    @ParameterizedTest(name = "{0} : {1}")
    void createLottoByOverSize(String situation, List<Integer> randomLottoNumber) {
        List<LottoNumber> numbers = convertToNumbers(randomLottoNumber);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<LottoNumber> convertToNumbers(List<Integer> randomLottoNumber) {
        return randomLottoNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    static Stream<Arguments> invalidLottoNumber() {
        return Stream.of(
                Arguments.of("개수가 6개보다 많은 경우", List.of(1,2,3,4,5,6,7)),
                Arguments.of("개수가 6개보다 적은 경우", List.of(1,2,3)),
                Arguments.of("중복된 숫자가 있는 경우", List.of(1,2,3,4,5,5))
        );
    }
}
