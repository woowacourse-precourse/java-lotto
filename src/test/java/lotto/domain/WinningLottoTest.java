package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    private static Stream<Arguments> testWinningNumber() {
        return Stream.of(
                Arguments.of(new WinningLotto(List.of(LottoNumber.lottoNumber(1),
                        LottoNumber.lottoNumber(2), LottoNumber.lottoNumber(3),
                        LottoNumber.lottoNumber(4), LottoNumber.lottoNumber(5),
                        LottoNumber.lottoNumber(6)), LottoNumber.lottoNumber(7))));
    }

    @ParameterizedTest
    @MethodSource("testWinningNumber")
    void countMatch(WinningLotto winningLotto) {
        List<LottoNumber> numbers = List.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2),
                LottoNumber.lottoNumber(3), LottoNumber.lottoNumber(7), LottoNumber.lottoNumber(41),
                LottoNumber.lottoNumber(42));
        Lotto lotto = new Lotto(numbers);

        assertEquals(winningLotto.countMatch(lotto), 3);
    }

    @ParameterizedTest
    @MethodSource("testWinningNumber")
    void bonus(WinningLotto winningLotto) {
        List<LottoNumber> numbers = List.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2),
                LottoNumber.lottoNumber(3), LottoNumber.lottoNumber(7), LottoNumber.lottoNumber(41),
                LottoNumber.lottoNumber(42));
        Lotto lotto = new Lotto(numbers);

        assertTrue(winningLotto.bonus(lotto));
    }

    @ParameterizedTest
    @MethodSource("testWinningNumber")
    void notBonus(WinningLotto winningLotto) {
        List<LottoNumber> numbers = List.of(LottoNumber.lottoNumber(1), LottoNumber.lottoNumber(2),
                LottoNumber.lottoNumber(3), LottoNumber.lottoNumber(8), LottoNumber.lottoNumber(41),
                LottoNumber.lottoNumber(42));
        Lotto lotto = new Lotto(numbers);

        assertFalse(winningLotto.bonus(lotto));
    }
}