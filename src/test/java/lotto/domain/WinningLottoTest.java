package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    private static Stream<Arguments> provide_WinningNumbers_And_DuplicatedBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(5, 6, 7, 8, 9, 10), 5),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 12)
        );
    }

    private static Stream<Arguments> provide_Lotto_And_Rank() {
        return Stream.of(
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), FIRST),
                Arguments.of(List.of(11, 12, 13, 14, 15, 17), SECOND),
                Arguments.of(List.of(11, 12, 13, 14, 15, 1), THIRD),
                Arguments.of(List.of(11, 12, 13, 14, 1, 17), FOURTH), //보너스번호 같은경우
                Arguments.of(List.of(11, 12, 13, 14, 1, 2), FOURTH),
                Arguments.of(List.of(11, 12, 13, 1, 2, 17), FIFTH),
                Arguments.of(List.of(11, 12, 13, 1, 2, 3), FIFTH),
                Arguments.of(List.of(11, 12, 1, 2, 3, 17), null),
                Arguments.of(List.of(11, 1, 2, 3, 4, 17), null),
                Arguments.of(List.of(1, 2, 3, 4, 5, 17), null)
        );
    }

    private static Stream<Arguments> provide_InvalidWinningNumbers_And_BonusNumber() {
        return Stream.of(
                //유효하지 않은 로또번호 (개수 / 중복 / 범위)
                Arguments.of(List.of(1, 2, 3), 45),
                Arguments.of(List.of(123456), 45),
                Arguments.of(List.of(7, 8, 9, 10, 11, 11), 45),
                Arguments.of(List.of(7, 8, 9, 10, 77, 58), 45),
                //유효하지 않은 로또번호와 중복 보너스 번호
                Arguments.of(List.of(1, 2, 3, 12), 12),
                //유효하지 않은 보너스 번호
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 55)
        );
    }

    private static Stream<Arguments> provide_WinningLotto_And_Rank() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, null), //null
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), 17, FIRST), //first
                Arguments.of(List.of(11, 12, 13, 14, 15, 1), 16, SECOND), //second
                Arguments.of(List.of(11, 12, 13, 14, 15, 1), 17, THIRD), //third
                Arguments.of(List.of(11, 12, 13, 14, 1, 2), 16, FOURTH), // fourth
                Arguments.of(List.of(11, 12, 13, 14, 1, 2), 17, FOURTH), // fourth
                Arguments.of(List.of(11, 12, 13, 3, 1, 2), 16, FIFTH) //fifth
        );
    }

    //보너스 번호 중복 테스트
    @DisplayName("당첨번호와 보너스 번호가 중복되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provide_WinningNumbers_And_DuplicatedBonusNumber")
    void validateBonusNumberTest(List<Integer> winningNumbers, int bonusNumber) {
        assertThatThrownBy(() ->
                WinningLotto.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //getRankOf 테스트
    @DisplayName("예상한 등수(enum)를 반환하는지 테스트")
    @ParameterizedTest
    @MethodSource("provide_Lotto_And_Rank")
    void getRankofTest(List<Integer> lottoNumbers, Rank expected) {
        WinningLotto winningLotto = new WinningLotto(List.of(11, 12, 13, 14, 15, 16), 17);

        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(winningLotto.getRankof(lotto)).isEqualTo(expected);
    }

    //생성자 테스트
    @DisplayName("유효하지 않은 로또 번호를 넣어 객체 생성을 시도하면, 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provide_InvalidWinningNumbers_And_BonusNumber")
    void createWinningLottoTest(List<Integer> winningNumbers, int bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 생성 및 getRankOf 테스트 동시에
    @DisplayName("유효한 값을 넣었을 때 WinningLotto를 생성하고, 예상한 등수(enum)를 반환하는지 테스트")
    @ParameterizedTest
    @MethodSource("provide_WinningLotto_And_Rank")
    void createWinningLotto_And_GetRankTest(List<Integer> winningNumbers, int bonusNumber, Rank expected) {
        lotto.domain.Lotto lotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        assertThat(winningLotto.getRankof(lotto)).isEqualTo(expected);
    }

}
