package lotto.domain;

import static lotto.util.LottoNumbersGenerator.lottoGenerator;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoNumbersGenerator;


public class User {
    private List<UserLotto> userLottos = new ArrayList<>();

    private int price;
    private int quantity;
    private int earnTotalMoney;

    public User(int price) {
        this.price = price;
        this.quantity = price / 1000;
        this.earnTotalMoney = 0;
    }

    public int getPrice() {
        return price;
    }

    public void setLottosCount(int quantity) {
        this.userLottos = lottoGenerator(quantity);
    }

    public List<UserLotto> getUserLottos() {
        return this.userLottos;
    }





}
