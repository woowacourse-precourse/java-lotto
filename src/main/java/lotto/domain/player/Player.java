package lotto.domain.player;

import static lotto.domain.lotto.LottoConstants.PRICE_UNIT;

public class Player {
    private int lottoCount;
    private int price;

    public void setLottoCount(String input) {
        this.validate(input);
        this.price = Integer.parseInt(input);
        this.lottoCount = calculateLottoCount();
    }

    private void validate(String input) {
        int price = Integer.parseInt(input);
        if (price < 0) {
            throw new IllegalArgumentException();
        }

        if (price % PRICE_UNIT.getNumber() != 0) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateLottoCount() {
        return price / PRICE_UNIT.getNumber();
    }

    public int getLottoCount() {
        return lottoCount;
    }


    public int getPrice() {
        return price;
    }
}
