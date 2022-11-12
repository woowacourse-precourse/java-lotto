package lotto.model.lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoLogicTest {

    private static Stream<Arguments> provideLottoList() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(7,8,9,10,11,12)), 0),
                Arguments.of(new Lotto(List.of(1,7,8,9,10,11)), 1),
                Arguments.of(new Lotto(List.of(1,2,7,8,9,10)), 2),
                Arguments.of(new Lotto(List.of(1,2,3,7,8,9)), 3),
                Arguments.of(new Lotto(List.of(1,2,3,4,7,8)), 4),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,7)), 5),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), 6)
        );
    }

    @ParameterizedTest
    @DisplayName("정답 로또와 주어진 로또의 숫자 일치 개수를 확인한다.")
    @MethodSource("provideLottoList")
    void countContainedLottoNumbers(Lotto userLotto, int answer) {
        //given
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        //then
        Assertions.assertThat(userLotto.countContainedNumbersIn(answerLotto)).isEqualTo(answer);
    }
}
