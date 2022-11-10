package lotto;

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
    @Test
    @DisplayName("로또 발행 횟수는 로또 구매 비용/1000 이다.")
    void publishNumTest() {
        assertThat(Lotto.getPublishNum("14000")).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 오름차순 정렬하기")
    void sortNaturalOrderLotto() {
        List<Integer> numbers = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1));
        assertThat(Lotto.sortNumbers(numbers)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
