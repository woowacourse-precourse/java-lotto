package lotto;

import camp.nextstep.edu.missionutils.Console;
import exception.IllegalAmountException;
import exception.NegativeInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


public class BuyerTest {
    @Test
    public void lottoCreation() {
        Buyer buyer =new Buyer();
        assertEquals(buyer.buyLotto(15000).size(), 15);

        assertThatThrownBy(() -> buyer.buyLotto(15400))
                .isInstanceOf(IllegalAmountException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> buyer.buyLotto(-1000))
                .isInstanceOf(NegativeInputException.class)
                .hasMessageContaining("[ERROR]");

    }

}
