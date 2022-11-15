package lotto.domain.lottomachine.lottoticket;

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

class LottoTicketsTest {
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        List<List<Integer>> lotteries = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 11, 12, 13, 14, 15));
        lottoTickets = LottoTickets.from(lotteries.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    @DisplayName("matchWith 메소드에 당첨번호와 보너스번호를 입력하면 맞춘 개수를 세서 리스트로 반환하는지 확인")
    @ParameterizedTest()
    @MethodSource("provideListForTest")
    void matchWith_test(List<Integer> numbers, int number, List<String> expected) {
        WinningNumbers winningNumbers = WinningNumbers.from(numbers.stream()
                .map(WinningNumber::from)
                .collect(Collectors.toList()));
        WinningNumber bonusNumber = WinningNumber.from(number);

        List<String> actual = lottoTickets.matchWith(winningNumbers, bonusNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("toString 메소드를 호출하면 리스트 요소를 대괄호([]) 안에 콤마(,)로 구분해서 한 줄씩 띈 문자열로 반환하는지 확인")
    @Test()
    void toString_test() {
        String actual = lottoTickets.toString();

        assertThat(actual).isEqualTo("[1, 2, 3, 4, 5, 6]\n" +
                "[1, 2, 3, 4, 5, 7]\n" +
                "[1, 11, 12, 13, 14, 15]");
    }

    static Stream<Arguments> provideListForTest() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of("6", "5B", "1"))
        );
    }
}