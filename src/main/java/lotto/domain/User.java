package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.UserBuyingException;

public class User {
    private final int buyingPrice;
    private final int winningPrice;
    private List<UserLotto> lottos;
    private final UserBuyingException userBuyingException = new UserBuyingException();

    public User(int buyingPrice) {
        userBuyingException.validBuyingException(buyingPrice);
        lottos = new ArrayList<>();
        this.buyingPrice = buyingPrice;
        this.winningPrice = 0;
    }


    public void setLottos(int buyingPrice) {
//        int quantity = buyingPrice / 1000;
//        for(int i=0; i<quantity; i++) {
//            Lotto lotto = new Lotto().createLotto();
//        }
    }
}
