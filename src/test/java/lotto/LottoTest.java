package lotto;

import lotto.input.UserInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1000원으로 나누어 떨어지지 않는 경우 예외 발생")
    @Test
    void createInputByDividedByZero(){
        Integer purchasePrice = 1200;
        assertThatThrownBy(() -> {
            if ((purchasePrice % 1000) > 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요");
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000원 단위로 입력해주세요");
    }

    @DisplayName("당첨,로또 번호를 1~45 사이의 숫자를 입력하지 않는 경우 예외 발생")
    @Test
    void createLottoNumberOutOfUnderBound(){
        Integer number = 0;
        assertThatThrownBy(() -> {
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}



