package lotto;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("구매자가 지불한 돈이 1,000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void validatePayment() {
        assertThatThrownBy(() -> LottoGenerator.validatePayment(10200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지불한 금액에 따라 로또 발행 개수가 달라진다.")
    @Test
    void countNumberOfLotto() {
        assertThat(LottoGenerator.countNumberOfLotto(12000)).isEqualTo(12);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬된다.")
    @Test
    void validateOrderOfLottoNumbers() {
        assertThat(LottoGenerator.orderNumbers(Arrays.asList(6, 5, 4, 3, 10, 1)))
                .isEqualTo(Arrays.asList(1, 3, 4, 5, 6, 10));
    }

    @DisplayName("지불한 금액 만큼의 로또가 생성된다.")
    @Test
    void generateLotto() {
        assertThat(LottoGenerator.generate("10000").size())
                .isEqualTo(10);
    }
    
}
