package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Lotto> lottoList;
    private Lotto winningLotto;
    private int userMoney;

    public Model() {
        this.lottoList = new ArrayList<>();
    }
    public List<Lotto> getLottoList() {
        return lottoList;
    }
    public void setUserMoney(int money) {
        this.userMoney = money;
    }
    public void generateLotto() {
        for (int i = 0; i < this.userMoney / 1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            this.lottoList.add(new Lotto(numbers));
        }
    }

}
