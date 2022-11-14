package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.*;

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

    @DisplayName("로또 번호에 1~45가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{index} : 로또 번호에 {0}가 있는지 확인 (결과 : {1})")
    @CsvSource({"1, true", "6, true", "7, false", "45, false"})
    void 로또_번호_포함_테스트(int number, boolean expected) {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        boolean actual = lotto.isMatch(number);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index} : 로또 번호 비교 테스트 (비교 결과 : {1})")
    @MethodSource("parametersProvider")
    void 로또_비교_테스트(List<Integer> userNumbers, int expected) {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(userNumbers);
        //when
        int actual = userLotto.compare(winningLotto);
        //then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
            arguments(List.of(1, 2, 3, 4, 5, 6), 6),
            arguments(List.of(11, 12, 13, 14, 15, 6), 1),
            arguments(List.of(11, 12, 13, 14, 15, 16), 0)
        );
    }
}
