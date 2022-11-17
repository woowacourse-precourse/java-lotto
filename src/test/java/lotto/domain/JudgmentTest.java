package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class JudgmentTest {

    static Stream<Arguments> setParametersForGetCorrectCount() {
        return Stream.of(
                Arguments.arguments(new ArrayList<Integer>(List.of(1, 2, 3, 7, 8, 9)), 3),
                Arguments.arguments(new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 11)), 5),
                Arguments.arguments(new ArrayList<Integer>(List.of(6, 5, 4, 3, 2, 1)), 6),
                Arguments.arguments(new ArrayList<Integer>(List.of(7, 8, 9, 10, 11, 12)), 0)
        );
    }

    @DisplayName("로또가 몇개의 당첨번호와 일치하는지 확인")
    @MethodSource("setParametersForGetCorrectCount")
    @ParameterizedTest(name = "[{index}] 당첨번호 : {0}. 결과 : {1} 개 일치")
    void getCorrectCount(List<Integer> winningLotto, int result) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(Judgment.getCorrectLottoNumberCount(lotto, winningLotto))
                .isEqualTo(result);
    }

    static Stream<Arguments> setParametersForCheckBonusNumberCorrect() {
        return Stream.of(
                Arguments.arguments(new ArrayList<Integer>(List.of(1, 2, 3, 7, 8, 9)), 3, true),
                Arguments.arguments(new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 11)), 13, false),
                Arguments.arguments(new ArrayList<Integer>(List.of(6, 5, 4, 3, 2, 1)), 6, true)
        );
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되어 있는지 확인")
    @MethodSource("setParametersForCheckBonusNumberCorrect")
    @ParameterizedTest(name = "[{index}] 로또 번호 : {0}, 보너스 번호 : {1}, 포함여부 : {2}")
    void checkBonusNumberCorrect(List<Integer> lotto, int bonusNumber, boolean result) {

        assertThat(Judgment.checkBonusCorrect(bonusNumber, lotto))
                .isEqualTo(result);
    }
}