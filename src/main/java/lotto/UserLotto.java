package lotto;

import static lotto.ErrorMessage.*;
import static lotto.InputValidator.*;

import java.util.List;

public class UserLotto {

    private final List<Lotto> userLotto;

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public UserLotto(String quantity) {
        validateQuantity(quantity);
        this.userLotto = purchaseLotto(quantity);
    }

    private List<Lotto> purchaseLotto(String quantity) {
        return null;
    }
}
