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
        assertThatThrownBy(()->{
            WinningLotto.validateBonusNumber(winningNumbers, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    //getRankOf 테스트 : 로또에 맞는 등수 얻어오는지 테스트

    //생성자 테스트 : 유효하지 않은 리스트 넣었을 때, 예외발생하는지 테스트 tmp파일 참고
}
