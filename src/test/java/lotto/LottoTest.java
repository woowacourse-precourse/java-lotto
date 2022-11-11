package lotto;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("입력된 로또 구입 금액이 정수 형태이면 int 타입으로 변환하여 반환한다.")
    @Test
    public void stringToIntTest() {
        assertThat(Application.stringToInt("34")).isEqualTo(34);
    }

    @DisplayName("입력된 로또 구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    public void priceFormatExceptionTest() {
        assertThatThrownBy(() -> Application.stringToInt("testString"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("적절하지 않은 로또 구입 금액이 입력될 경우 예외가 발생한다.")
    @Test
    public void validatePrice() {
        // 금액이 0보다 작은 경우
        assertThatThrownBy(() -> Application.validatePrice(-5))
                .isInstanceOf(IllegalArgumentException.class);
        // 1회 구매 수량 제한을 초과하는 금액인 경우
        assertThatThrownBy(() -> Application.validatePrice(20000000))
                .isInstanceOf(IllegalArgumentException.class);
        // 금액이 1000원 단위가 아닌 경우
        assertThatThrownBy(() -> Application.validatePrice(1234))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
