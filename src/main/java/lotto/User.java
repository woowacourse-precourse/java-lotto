package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int count = 0;

    public List<List<Integer>> Count(int money){
        int count = money/1000;
        CheckMoney(money);
        List<List<Integer>> UserLotto = new ArrayList<>();
        for(int i = 0;i<count;i++){
            UserLotto.add(i,Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return UserLotto;
    }

    private void CheckMoney(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException();
        }
    }
}
