package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> lottoMachine.validateLottoNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개의 숫자가 아닙니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> lottoMachine.validateLottoNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 수가 있습니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 정렬이 되어있지 않으면 예외가 발생한다.")
    @Test
    void createLottoByUnsortedNumber() {
        assertThatThrownBy(() -> lottoMachine.validateLottoNumber(List.of(3, 2, 1, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 정렬되어 있지 않습니다.");
    }

    @DisplayName("로또 번호가 범위 내에 있지 않으면 예외가 발생힌다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> lottoMachine.validateLottoNumber(List.of(1,2,3,4,5,100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자중 범위 밖의 숫자가 있습니다.");
    }

}