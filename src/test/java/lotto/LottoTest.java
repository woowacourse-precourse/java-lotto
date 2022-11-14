package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    @DisplayName("로또의 마킹역할 하는 리스트를 제대로 봔한하는지 확인")
    @Test
    void 로또_마킹_반환_테스트() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getLottoInfo())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("List를 제대로 출력하는지 확인")
    @Test
    void 로또_번호_출력_테스트() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6).toString());
    }
}
