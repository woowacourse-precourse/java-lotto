package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.BonusNumber;

public class BonusNumberTest {
    private static BonusNumber bonusNumber;

    @BeforeAll
    static void setBonusNumber() {
        bonusNumber = new BonusNumber(7);
    }

    @DisplayName("범위를 벗어난 값이 들어왔을 경우")
    @ParameterizedTest(name = "{index} {displayName} input = {0}")
    @ValueSource(ints = {-1, 0, 46})
    void checkBonusNumberException(int input) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 넘버 포함되었는지 테스트")
    @ParameterizedTest(name = "input = {0}")
    @MethodSource("generateDataForContainBonusNumberTest")
    void checkContainBonusNumber(List<Integer> purchasedLotto, boolean expect) {
        boolean result = BonusNumberTest.bonusNumber.checkContainBonusNumber(purchasedLotto);
        assertThat(result).isEqualTo(expect);
    }

    static Stream<Arguments> generateDataForContainBonusNumberTest() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,7), true),
                Arguments.of(List.of(1,2,3,4,5,8), false)
        );
    }
}
