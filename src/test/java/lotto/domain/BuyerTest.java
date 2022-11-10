package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

public class BuyerTest {
    @Test
    public void playTest() {
        Buyer buyer = Buyer.newInstance();
        buyer.buy(List.of(1,2,3,4,5,6));
        buyer.buy(List.of(7,8,9,10,11));
    }
}
