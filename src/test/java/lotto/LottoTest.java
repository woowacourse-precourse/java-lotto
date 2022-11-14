package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    private static Stream<Arguments> provideLottoNumberListToCheckValidSize() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(1, 2, 3, 4)),
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
        );
    }

    private static Stream<Arguments> provideDuplicatedLottoNumberList() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,5)),
                Arguments.of(List.of(1,2,3,5,5,5)),
                Arguments.of(List.of(1,2,5,5,5,5)),
                Arguments.of(List.of(1,5,5,5,5,5)),
                Arguments.of(List.of(5,5,5,5,5,5))
        );
    }

    private static Stream<Arguments> provideInvalidRangeLottoNumberList() {
        return Stream.of(
                Arguments.of(List.of(-1,2,3,4,5,6)),
                Arguments.of(List.of(0,2,3,4,5,6)),
                Arguments.of(List.of(1,2,3,4,5,46)),
                Arguments.of(List.of(1,2,3,4,5,100))
        );
    }

    private static Stream<Arguments> provideLottoListForCheckContainedCount() {
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
    @DisplayName("로또 번호의 개수 6이 아닌 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @MethodSource("provideLottoNumberListToCheckValidSize")
    void createLottoByInvalidSize(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoConstants.INVALID_LOTTO_SIZE_MSG);
    }

    @ParameterizedTest
    @DisplayName("로또 숫자 중 중복된 값이 있는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @MethodSource("provideDuplicatedLottoNumberList")
    void createLottoByDuplicatedNumbers(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoConstants.DUPLICATE_NUMBER_EXIST_MSG);
    }

    @ParameterizedTest
    @DisplayName("리스트로 주어진 로또 값 중 유효하지 않은 값이 존재하는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @MethodSource("provideInvalidRangeLottoNumberList")
    void createLottoByInvalidRangedList(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoConstants.INVALID_RANGED_LOTTO_MSG);
    }

    @ParameterizedTest
    @DisplayName("정답 로또와 주어진 로또의 숫자 일치 개수를 확인한다.")
    @MethodSource("provideLottoListForCheckContainedCount")
    void countContainedLottoNumbers(Lotto userLotto, int answer) {
        //given
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        //then
        Assertions.assertThat(userLotto.countContainedNumbersIn(answerLotto)).isEqualTo(answer);
    }



}
