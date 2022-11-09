package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private final int startNumber = 1;
    private final int endNumber = 45;
    private final int count = 6;
    private int money;
    private List<List<Integer>> myLottoNumbers;

    public User(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
        myLottoNumbers = new ArrayList<>();
        makeMyLottoNumbers();
    }

    public int getMoney() {
        return money;
    }

    public List<List<Integer>> getMyLottoNumbers() {
        return myLottoNumbers;
    }

    private void makeMyLottoNumbers(){
        int times = this.money / 1000;
        for (int i = 0; i < times; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
            Collections.sort(numbers);
            myLottoNumbers.add(numbers);
        }
    }

    private void validate(String money) {
        if (!isMoney(money)){
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isMoney(String money){
        char[] chars = money.toCharArray();
        for (char c : chars) {
            if(!isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(char c){
        if (c < '0' && c > '9'){
            return false;
        }
        return true;
    }
}
