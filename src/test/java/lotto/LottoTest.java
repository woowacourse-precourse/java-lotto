package lotto;

import lotto.model.CompareResult;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
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

    WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
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

    @ParameterizedTest(name = "당첨 번호 일치 개수: {1}, 보너스 번호 가지고 있어?: {2}")
    @MethodSource("lottoAndCompareResult")
    void 로또가_당첨번호를_몇개_가지는지_확인하는_기능(Lotto lotto, int numberOfMatches, boolean hasBonus) {
        assertThat(lotto.compareWith(winningNumbers))
                .isEqualTo(new CompareResult(numberOfMatches, hasBonus));
    }

    static Stream<Arguments> lottoAndCompareResult() {
        return Stream.of(
            Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), 6, false)
                , Arguments.of(new Lotto(List.of(1,3,7,4,5,6)), 5, true)
                , Arguments.of(new Lotto(List.of(1,2,3,13,5,6)), 5, false)
                , Arguments.of(new Lotto(List.of(1,28,13,4,5,6)), 4, false)
                , Arguments.of(new Lotto(List.of(21,2,3,4,7,12)), 3, true)
                , Arguments.of(new Lotto(List.of(1,12,23,4,35,7)), 2, true)
        );
    }
}
