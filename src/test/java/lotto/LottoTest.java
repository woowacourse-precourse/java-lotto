package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("발행된 하나의 로또의 숫자는 1 ~ 45의 값을 갖는 6개의 중복되지 않는 숫자이다.")
    @Test
    void createLottoByRangeNumber() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lotto = lottoMachine.getLottoNumber();

        assertThat(lotto.size()).isEqualTo(6);
        assertThat(lotto).doesNotHaveDuplicates();

        lotto.stream().forEach(
                (number) -> Assertions.assertTrue(1 <= number && number <= 45)
        );
    }
}
