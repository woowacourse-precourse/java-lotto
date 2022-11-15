package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoInputTest {

    @Test
    @DisplayName("Money 생성시 단위가 1000 이 아닐시 IllegalArgumentException 발생")
    public void 예외테스트_1() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Money.of(2100L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력금액은 1000원 단위여야 합니다.");

    }

    @DisplayName("LottoInput 생성시 발생하는 예외 테스트")
    @ParameterizedTest(name = "{index} => {2} 을 메시지로 가지는 IllegalArgumentException 가 발생  해야한다.")
    @MethodSource("provideLottoInputArgumentsAndExpectedExceptionMessage")
    public void 예외테스트_2(List<Integer> winningNumber, int bonusNumber, String expectedMsg) {
        //given
        Money money = Money.of(2000L);
        //when
        //then
        assertThatThrownBy(() -> LottoInput.create(winningNumber, bonusNumber, money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMsg);
    }

    private static Stream<Arguments> provideLottoInputArgumentsAndExpectedExceptionMessage() {
        // 당첨번호, 보너스번호, 예외메시지
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 6, 6), 7, "[ERROR] 중복된 정수를 입력하면 안됩니다."),
                Arguments.of(List.of(11, 12, 1, 40, 35, 6), 6, "[ERROR] 중복된 정수를 입력하면 안됩니다."),
                Arguments.of(List.of(1, 2, 10, 15, 20, 46), 13, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
                Arguments.of(List.of(10, 20, 30, 13, 21, 40), 46, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
                Arguments.of(List.of(1, 5, 15, 21, 40), 41, "[ERROR] 당청번호의 갯수는 6개입니다.")

        );
    }
}
