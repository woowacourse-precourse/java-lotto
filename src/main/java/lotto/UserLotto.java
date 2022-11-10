package lotto;

import static lotto.InputValidator.*;

import java.util.List;

public class UserLotto {

    private final List<Lotto> userLotto;

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public UserLotto(String pay) {
        validatePay(pay);
        this.userLotto = purchaseLotto(pay);
    }

    private List<Lotto> purchaseLotto(String pay) {


        return null;
    }
}
