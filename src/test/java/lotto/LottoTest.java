package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호를 정렬하여 보여준다.")
    @Test
    void sortLottoNumbers() {

        List<Integer> sortedNumbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(List.of(3, 2, 4, 1, 5, 6));
        List<Integer> result = lotto.getSortedNumbers();

        assertThat(result).isEqualTo(sortedNumbers);
    }

    @ParameterizedTest(name="당첨 등수를 확인한다.: {0}")
    @MethodSource("checkWinningRankSource")
    void checkWinningRank(String testName, List<Integer> lottoNumbers, String rank) {
        List<Integer> winningNums = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        Lotto lotto = new Lotto(lottoNumbers);
        String resultRank = lotto.checkWinningNums(winningNums, bonusNum);

        assertThat(resultRank).isEqualTo(rank);
    }

    static Stream<Arguments> checkWinningRankSource(){
        return Stream.of(
            Arguments.of("1등 case", List.of(1, 2, 3, 4, 5, 6), "1등"),
            Arguments.of("2등 case", List.of(1, 2, 3, 4, 5, 7), "2등"),
            Arguments.of("3등 case", List.of(1, 2, 3, 4, 5, 8), "3등"),
            Arguments.of("4등 case", List.of(1, 2, 3, 4, 9, 10), "4등"),
            Arguments.of("5등 case", List.of(1, 2, 3, 9, 10, 11), "5등"),
            Arguments.of("당첨 X case", List.of(12, 13, 14, 9, 10, 11), "당첨 X")
            );
    }

}
