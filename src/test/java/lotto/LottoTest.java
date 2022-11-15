package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("parametersProvider")
    void 몇등_인지_확인(Lotto lotto, List<String> winningNumbers, int bonusNumber, int answer){
        int checked = lotto.checkRanking(winningNumbers, bonusNumber);

        assertThat(checked).isEqualTo(answer);
    }

    private static Stream<Arguments> parametersProvider(){
        return Stream.of(
                Arguments.arguments(new Lotto(List.of(15,34,10,1,2,3)), List.of("15","24","1","2","3","4"), 7, 1),
                Arguments.arguments(new Lotto(List.of(15,5,10,1,2,3)), List.of("15","5","1","2","3","4"), 8, 2),
                Arguments.arguments(new Lotto(List.of(15,5,10,1,2,3)), List.of("15","5","1","2","3","4"), 10, 3),
                Arguments.arguments(new Lotto(List.of(15,5,10,1,2,3)), List.of("15","5","10","2","3","1"), 8, 4),
                Arguments.arguments(new Lotto(List.of(15,5,10,1,2,3)), List.of("16","17","18","19","20","21"), 8, 5)
        );
    }

}
