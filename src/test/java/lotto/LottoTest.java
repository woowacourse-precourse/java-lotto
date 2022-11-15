package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private final Service service = new Service();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 60)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void moneyInputIsNotNumber() {
        assertThatThrownBy(() -> service.getLottoCount("122gfgg"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력값이 1000 단위가 아니면 예외가 발생한다.")
    @Test
    void moneyInputIsNotRightFormat() {
        assertThatThrownBy(() -> service.getLottoCount("1230"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 맞는 로또 개수를 반환한다.")
    @Test
    void getLottoCount() {
        assertThat(service.getLottoCount("5000")).isEqualTo(5);
        assertThat(service.getLottoCount("23000")).isEqualTo(23);
        assertThat(service.getLottoCount("2000")).isEqualTo(2);
    }


}
