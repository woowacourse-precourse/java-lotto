package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int startNumber = 1;
    private final int endNumber = 45;
    private final int count = 6;
    private Integer money;
    private List<Lotto> myLottoNumbers;

    public User(Integer money) {
        this.money = money;
        makeMyLottoNumbers();
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getMyLottoNumbers() {
        return myLottoNumbers;
    }

    private void makeMyLottoNumbers(){
        myLottoNumbers = new ArrayList<>();
        int times = this.money / 1000;
        for (int i = 0; i < times; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
            myLottoNumbers.add(new Lotto(numbers));
        }
    }
}
