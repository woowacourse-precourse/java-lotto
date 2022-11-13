package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {

    @Test
    void buyLotto() {
        Buyer buyer = new Buyer();

        buyer.buyLotto(3030);
    }
}