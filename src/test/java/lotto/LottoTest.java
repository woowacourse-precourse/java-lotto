package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.Lotto.LottoMatch.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("정상적으로 수행되는 경우.")
    @Test
    void calculateLottoResultByProperInput() {
        List<List<Integer>> generatedRandomLotto1 = List.of(List.of(1, 2, 3, 7, 8, 9));
        List<List<Integer>> generatedRandomLotto2 = List.of(List.of(4, 5, 6, 7, 8, 9), List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 3, 4, 5, 9), List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userInput = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        Lotto lotto = new Lotto(userInput);
        assertAll(
                () -> assertThat(lotto.calculateLottoStatistics(generatedRandomLotto1, bonus)).
                        isEqualTo(Map.of(MATCH_THREE, 1)),
                () -> assertThat(lotto.calculateLottoStatistics(generatedRandomLotto2, bonus)).
                        isEqualTo(Map.of(MATCH_THREE, 1, MATCH_FOUR, 1, MATCH_FIVE, 1,
                                MATCH_FIVE_WITH_BONUS, 1, MATCH_SIX, 1))
        );

    }
    // 아래에 추가 테스트 작성 가능
}
