package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    private static final Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

    @DisplayName("제공된 로또번호와 일치하는 번호 개수 세기 기능 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndExpected")
    void calculateMatchCountTest(List<Integer> winningNumbers,int expected) {
        assertThat(lotto.calculateMatchCount(winningNumbers))
            .isEqualTo(expected);
    }

    private static Stream<Arguments> provideWinningNumbersAndExpected() {
        return Stream.of(
            Arguments.of(List.of(1,2,3,4,5,6) , 6),
            Arguments.of(List.of(1,26,3,45,15,6) , 3),
            Arguments.of(List.of(13,21,32,24,15,6) , 1),
            Arguments.of(List.of(1,2,3,4,5,11) , 5)
        );
    }
    @DisplayName("보너스 번호를 가지고 있는지 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "7,false"})
    void hasBonusNumberTest(int bonusNumber,boolean expected) {
        assertThat(lotto.hasBonusNumber(bonusNumber)).isEqualTo(expected);
    }

}
