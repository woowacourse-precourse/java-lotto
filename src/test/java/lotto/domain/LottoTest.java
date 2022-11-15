package lotto.domain;

import static lotto.domain.Prize.FIVE;
import static lotto.domain.Prize.FIVE_AND_BONUS;
import static lotto.domain.Prize.FOUR;
import static lotto.domain.Prize.NOTING;
import static lotto.domain.Prize.SIX;
import static lotto.domain.Prize.THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
//    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
//    @Test
//    void createLottoByOverSize() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 일치갯수에 해당하는 Prize 가 생성되어야한다.")
    @ParameterizedTest(name = "{index} => {0} 당첨번호 {1} 보너스 번호 일때 {2} 생성")
    @MethodSource("provideWinningAndBonusNumberForCreatePrize")
    public void Prize_생성_테스트(List<Integer> winningNumbers, int bonusNumber, Prize expected) {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        Prize actual = lotto.toPrize(winningNumbers, bonusNumber);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWinningAndBonusNumberForCreatePrize() { // argument source method
        //당첨번호, 보너스번호, 당첨결과
        return Stream.of(
                Arguments.of(List.of(10, 20, 30, 40, 41, 42), 12, NOTING),
                Arguments.of(List.of(1, 2, 3, 10, 20, 30), 40, THREE),
                Arguments.of(List.of(1, 2, 3, 4, 10, 20), 30, FOUR),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), 20, FIVE),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), 6, FIVE_AND_BONUS),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 10, SIX)
                );
    }
}
