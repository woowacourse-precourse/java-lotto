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

    private static Stream<Arguments> provideDuplicatedNumbersAndBonusNumber() {
        return Stream.of(
            Arguments.of(List.of(5,6,7,8,9,10), 5),
            Arguments.of(List.of(7,8,9,10,11,12), 12)
        );
    }

    @DisplayName("당첨번호와 보너스 번호가 중복되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideDuplicatedNumbersAndBonusNumber")
    void validateBonusNumberTest(List<Integer> winningNumbers, int bonusNumber) {
        assertThatThrownBy(()->
            WinningLotto.validateBonusNumber(winningNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }


    //getRankOf 테스트
    @DisplayName("예상한 등수(enum)를 반환하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoAndRank")
    void getRankofTest(List<Integer> lottoNumbers, Rank expected) {
        WinningLotto winningLotto = new WinningLotto(List.of(11,12,13,14,15,16), 17);

        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(winningLotto.getRankof(lotto)).isEqualTo(expected);
    }

    private static  Stream<Arguments> provideLottoAndRank() {
        return Stream.of(
            Arguments.of(List.of(11,12,13,14,15,16), FIRST),
            Arguments.of(List.of(11,12,13,14,15,17), SECOND),
            Arguments.of(List.of(11,12,13,14,15,1), THIRD),
            Arguments.of(List.of(11,12,13,14,1,17), FOURTH), //보너스번호 같은경우
            Arguments.of(List.of(11,12,13,14,1,2), FOURTH),
            Arguments.of(List.of(11,12,13,1,2,17), FIFTH),
            Arguments.of(List.of(11,12,13,1,2,3), FIFTH),
            Arguments.of(List.of(11,12,1,2,3,17), null),
            Arguments.of(List.of(11,1,2,3,4,17), null),
            Arguments.of(List.of(1,2,3,4,5,17), null)
        );
    }


    //생성자 테스트 : 유효하지 않은 리스트 넣었을 때, 예외발생하는지 테스트 tmp파일 참고
}
