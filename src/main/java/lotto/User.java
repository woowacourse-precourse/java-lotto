package lotto;

import java.util.List;

public class User {
    private List<Lotto> userLotto;

    public User(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }
}
