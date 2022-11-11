package lotto.model;

import java.lang.reflect.Array;
import java.util.List;

public class Shop {
    private int price;
    private int lottoSize;
    private List<Lotto> lottoPayed;

    public Shop(int price){
        this.price = price;
        this.lottoSize = calcLottoSize(price);
    }

    public List<Lotto> getlottoPayed() {
        return null;
    }

    private int calcLottoSize(int price) {
        priceValidate(price);
        return (price / 1000);
    }

    private void setLottoPayed(int lottoSize) {

    }

    private void priceValidate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
