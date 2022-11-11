package domain;

import java.util.List;

public class UserLotto {
    private final List<List<Integer>> userLotto;

    public UserLotto(List<List<Integer>> userLotto) {
        this.userLotto = userLotto;
    }

    public List<Integer> getUserLottoNumbers(int index) {
        return userLotto.get(index);
    }

    public int getUserLottoSize() {
        return userLotto.size();
    }
}