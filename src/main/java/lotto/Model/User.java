package lotto.Model;


import lotto.Constant;
import lotto.Error;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private List<Lotto> userLotto;
    private int price;

    public User() {
        userLotto = new ArrayList<>();
        price = 0;
    }

    public void setUserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }

    public int getPrice() {
        return price;
    }

    public void showUserLottoBundle(){
        System.out.println();
        System.out.println(price / 1000 + Constant.SHOW_BUY_COUNT);
        for (Lotto lotto : userLotto) {
            List<Integer> temporaryLotto = new ArrayList<>();
            temporaryLotto.addAll(lotto.getNumbers());
            Collections.sort(temporaryLotto);
            System.out.println(temporaryLotto.toString());
        }
        System.out.println();
    }
}
