package lotto;

import static lotto.ErrorMessage.*;

import java.util.List;

public class UserLotto {

    private final List<Lotto> userLotto;

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public UserLotto(String quantity) {
        this.userLotto = purchaseLotto(quantity);
    }

    private List<Lotto> purchaseLotto(String quantity) {
        return null;
    }
}
