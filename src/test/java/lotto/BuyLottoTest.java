package lotto;

import lotto.domain.vo.BuyLotto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyLottoTest {

    @DisplayName("money 값에 들어가는지 테스트")
    @Test
    void createMoney() {
        BuyLotto buyLotto = new BuyLotto("5000");
        AssertionsForClassTypes.assertThat(buyLotto.getMoney()).isEqualTo(5000);
    }

    @DisplayName("1000원 단위의 돈이 아닐 경우 exception 발생 테스트")
    @Test
    void createNotMoneyUnit() {
        assertThatThrownBy(() -> new BuyLotto("5500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
