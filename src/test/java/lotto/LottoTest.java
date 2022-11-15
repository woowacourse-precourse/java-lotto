package lotto;

import org.assertj.core.api.Assertions;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("금액에 맞게 로또를 발행해야 한다.")
    @Test
    void buyLottoTest1 (){
        int money = 5000;
        int number = Lotto.count(money);
        Assertions.assertThat(number).isEqualTo(5);
    }

    @DisplayName("1000원 단위가 아니면 예외로 처리해야 한다.")
    @Test
    void buyLottoTest2 (){
        int money = 5500;
        assertThatThrownBy(() -> Lotto.count(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 단위로 입력해야 합니다.");
    }
    @DisplayName("금액을 잘못 입력하면 예외를 발생시켜야 한다.")
    @Test
    void buyLottoTest3 (){
        int money = -5000;
        assertThatThrownBy(() -> Lotto.count(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 값을 잘못 입력하였습니다.");
    }
}
