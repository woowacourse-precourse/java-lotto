package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerCheckerTest {
    @DisplayName("로또 번호 비교하기")
    @ParameterizedTest(name = "{displayName} {0} {1}개 일치")
    @MethodSource("generateData")
    void compareLottoNumbers(List<Integer> numbers, int numberOfMatches) {
        WinnerChecker winnerChecker = new WinnerChecker();
        Lotto purchasedLotto = new Lotto(numbers);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winnerChecker.compareLottoNumbers(purchasedLotto, winningLotto)).isEqualTo(numberOfMatches);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), 5),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), 0)
        );
    }

    @DisplayName("로또 보너스번호가 있는지 확인.")
    @ParameterizedTest(name = "{displayName} {0}이면 {1}")
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void hasBonusNumber(int bonunsNumber, boolean hasBounsNumber) {
        WinnerChecker winnerChecker = new WinnerChecker();
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean result = winnerChecker.hasBonusNumber(purchasedLotto, bonunsNumber);

        assertThat(result).isEqualTo(hasBounsNumber);
    }

    @DisplayName("로또 테이블 비교하기")
    @Test
    void compareLottoTable() {
        WinnerChecker winnerChecker = new WinnerChecker();
        List<Lotto> lottoTable = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 5, 16)),
                new Lotto(List.of(1, 2, 3, 4, 15, 45)),
                new Lotto(List.of(1, 2, 3, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonunsNumber = 45;
        List<Integer> result = winnerChecker.compareLottoTable(lottoTable, winningLotto, bonunsNumber);

        assertThat(result).isEqualTo(List.of(6, 15, 5, 4, 3, 0));
    }

    @DisplayName("로또 테이블 비교시 당첨번호에 보너스번호가 있으면 예외")
    @Test
    void compareLottoTableButException() {
        WinnerChecker winnerChecker = new WinnerChecker();
        List<Lotto> lottoTable = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonunsNumber = 6;

        assertThatThrownBy(() -> winnerChecker.compareLottoTable(lottoTable, winningLotto, bonunsNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
