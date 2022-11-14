package lotto.service;

import lotto.exception.BonusNumberException;
import lotto.exception.BuyMoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyLottoTest {
    private BuyLotto buyLotto;

    @BeforeEach
    public void setUp() {
        buyLotto = new BuyLotto();
    }

    @Test
    @DisplayName("구매_금액_단위")
    public void buyMoney() {
        assertThatThrownBy(() -> new BuyMoneyException().notDivideThousands("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또_구매_개수")
    public void buyLottos() {
        int quantity = 5;
        assertThat(buyLotto.getMyLottoNumbers(quantity).size())
                .isEqualTo(5);
    }
}
