package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    public List<Lotto> userLotto = new ArrayList<>();

    public void getUserLotto(int price){
        int lottoCount = price/1000;
        for (int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLotto.add(new Lotto(numbers));
        }
    }
    public void printUserLotto(){

    }
    public void printWinningResult(){

    }
    public void printWinnintRatio(){

    }
}
