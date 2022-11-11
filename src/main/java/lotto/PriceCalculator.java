package lotto;

import java.util.Map;

public class PriceCalculator {

    private final Map<Rank, Integer> winStatus;
    private int price = 0;

    public PriceCalculator(Map<Rank, Integer> winStatus) {
        this.winStatus = winStatus;
        getPrice(winStatus);
    }

    private void getPrice(Map<Rank, Integer> winStatus) {

    }
}
