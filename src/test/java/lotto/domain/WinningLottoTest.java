package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {
    private final Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    private static Stream<Arguments> generateLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoResult(LottoSameCount.from(6), LottoContainBonus.from(false))),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new LottoResult(LottoSameCount.from(5), LottoContainBonus.from(true))),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 9)),
                        new LottoResult(LottoSameCount.from(5), LottoContainBonus.from(false))),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                        new LottoResult(LottoSameCount.from(4), LottoContainBonus.from(false))),
                Arguments.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                        new LottoResult(LottoSameCount.from(3), LottoContainBonus.from(false))),
                Arguments.of(new Lotto(List.of(1, 2, 11, 12, 13, 14)),
                        new LottoResult(LottoSameCount.from(2), LottoContainBonus.from(false))),
                Arguments.of(new Lotto(List.of(1, 12, 13, 14, 15, 16)),
                        new LottoResult(LottoSameCount.from(1), LottoContainBonus.from(false)))
        );
    }

    @DisplayName("setBonusNumber 메서드는 중복이 없는 숫자만을 받아들인다")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 45})
    void case1(int input) {
        BonusNumber bonusNumber = new BonusNumber(input);
        assertDoesNotThrow(() -> new WinningLotto(winLotto, bonusNumber));
    }

    @DisplayName("setBonusNumber 메서드에 중복인 숫자가 오면 IEA 예외")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void case2(int input) {
        BonusNumber bonusNumber = new BonusNumber(input);
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(winLotto, bonusNumber));
    }

    @DisplayName("getResult 메서드는 당첨 결과를 알맞게 LottoResult 형태로 반환한다")
    @ParameterizedTest
    @MethodSource("generateLotto")
    void case3(Lotto lotto, LottoResult expected) {
        WinningLotto winningLotto = new WinningLotto(winLotto, new BonusNumber(7));
        LottoResult result = winningLotto.calculateLottoResult(lotto);
        assertThat(result).isEqualTo(expected);
    }
}
