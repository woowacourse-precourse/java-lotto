package lotto;

import java.util.ArrayList;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("로또 번호가 정렬 되는지 테스트")
    @Test
    void orderbyLottoNumber() {
        List<Integer> testdata = new ArrayList<>();
        testdata.addAll(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> testLottodata = new ArrayList<>();
        testLottodata.addAll(List.of(1, 3, 6, 4, 5, 2));
        assertThat(new Lotto(testLottodata).getNumbers()).isEqualTo(testdata);
    }

    // 아래에 추가 테스트 작성 가능
}
