package lotto;

import lotto.domain.lottomachine.lottoticket.Lotto;
import lotto.domain.lottomachine.winningnumber.WinningNumber;
import lotto.domain.lottomachine.winningnumber.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private WinningNumbers winningNumbers;
    private WinningNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumbers = WinningNumbers.from(Stream.of(1, 2, 3, 4, 5, 6)
                .map(WinningNumber::from)
                .collect(Collectors.toList()));
        bonusNumber = WinningNumber.from(7);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호에 중복된 숫자가 있을 수 없습니다.");
    }

    @DisplayName("countNumbersConsistentWith 메소드에 당첨번호와 보너스 번호를 입력할 때 일치하는 숫자의 개수를 세서 반환하는지 확인")
    @ParameterizedTest()
    @MethodSource("provideNumbersForTest")
    void countNumbersConsistentWith_test(List<Integer> numbers, String expected) {
        Lotto lotto = new Lotto(numbers);

        String actual = lotto.countNumbersConsistentWith(winningNumbers, bonusNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("toString 메소드가 로또 번호 리스트를 문자열로 반환하는지 확인")
    @Test()
    void toString_test() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        String actual = lotto.toString();

        assertThat(actual).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    static Stream<Arguments> provideNumbersForTest() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "6"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), "5B"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), "5"),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), "4"),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), "3"),
                Arguments.of(List.of(1, 2, 7, 8, 9, 10), "2"),
                Arguments.of(List.of(1, 7, 8, 9, 10, 11), "1"),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), "0")
        );
    }
}
