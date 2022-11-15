package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyLottoTest {
    @DisplayName("금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void under1000won() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new BuyLotto("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액을 1000원단위로 입력하지 않으면 예외가 발생한다.")
    @Test
    void currencyNotmatch() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() ->  new BuyLotto("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("금액을 입력하면 로또구매개수를 출력한다.")
    @Test
    void buyLotto() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertEquals(new BuyLotto("1000").buyLotto(),1);
    }
}
