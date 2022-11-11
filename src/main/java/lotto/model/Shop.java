package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private int price;
    private int lottoSize;
    private List<Lotto> lottoPayed;

    public Shop(int price){
        this.price = price;
        this.lottoSize = calcLottoSize(price);
        this.lottoPayed = setLottoPayed(this.lottoSize);
    }

    public List<Lotto> getlottoPayed() {
        return null;
    }

    private int calcLottoSize(int price) {
        priceValidate(price);
        return (price / 1000);
    }

    private List<Lotto> setLottoPayed(int lottoSize) {

        return null;
    }

    private Lotto getRandomLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    private void priceValidate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
