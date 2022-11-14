package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer money;
    private List<Lotto> myLottoNumbers;

    public User(Integer money) {
        this.money = money;
        makeMyLottoNumbers();
    }

    public User() {
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setMyLottoNumbers(List<Lotto> myLottoNumbers) {
        this.myLottoNumbers = myLottoNumbers;
    }

    public List<Lotto> getMyLottoNumbers() {
        return myLottoNumbers;
    }

    private void makeMyLottoNumbers() {
        myLottoNumbers = new ArrayList<>();
        int times = this.money / 1000;
        for (int i = 0; i < times; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Const.START_NUMBER, Const.END_NUMBER, Const.COUNT);
            myLottoNumbers.add(new Lotto(numbers));
        }
    }
}
