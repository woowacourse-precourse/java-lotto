package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class User {
    private List<List<Integer>> boughtLotto;
    private int lottoCount;

    // 로또 구매 개수 구현
    public int buyingLotto(){
        String input = Console.readLine();
        int money = UserMissChecking.numberChecking(input);
        return money / 1000;
    }

    // 구매한 크기만큼의 로또 제공 메소드
    public List<List<Integer>> generatingLotto(List<List<Integer>> boughtLotto, int lottoCount){
        for(int i = 0; i <lottoCount; i++){
            while (boughtLotto.get(i).size() < 6){
                int lottoNum = Randoms.pickNumberInRange(1,45);
                if(!boughtLotto.get(i).contains(lottoNum)) boughtLotto.get(i).add(lottoCount);
            }
        }
        return boughtLotto;
    }
}
