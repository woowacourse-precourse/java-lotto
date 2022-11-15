package lotto;

import lotto.model.Lotto;
import lotto.model.LottoCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("생성자로 만들어 준 번호들이 변경되지 않는지 확인")
    @Test
    void equalSameNumbers() {
        final int testCount = 1;
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        List<Integer> expected = lotto.getNumbers();

        LottoCalculator lottoCalculator = new LottoCalculator();
        List<Lotto> lottos = new ArrayList<>(testCount);
        lottos.add(lotto);
        ArrayList<ArrayList<Integer>> result = lottoCalculator.getDisplayLottoNumbers(lottos);
        ArrayList<Integer> notEqualExpected = result.get(0);
        List<Integer> actual = lotto.getNumbers();

        assertThat(actual).isEqualTo(expected).isNotEqualTo(notEqualExpected);
    }

}
