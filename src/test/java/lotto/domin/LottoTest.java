package lotto.domin;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @DisplayName("1~45의 정수 외에 입력은 예외가 발생한다.")
    @Test
    void createLottoByInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 번호는 정렬한다.")
    @Test
    void createLottoBySortedNumber() {
        Lotto lotto = new Lotto(List.of(6, 4, 5, 3, 1, 2));
        assertThat(lotto.toString()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6).toString());
    }

    // 아래에 추가 테스트 작성 가능
}
