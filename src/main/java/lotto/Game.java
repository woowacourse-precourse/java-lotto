package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.check.Check;
import lotto.domain.Lotto;
import lotto.view.Print;

import java.util.*;
public class Game {
    public static List<List<Integer>> autoNumber = new ArrayList<>();
    public static List<Integer> luckyNumber = new ArrayList<>();
    public static int luckyCount = 0;
    public static int threeLuckyCount = 0;
    public static int fourLuckyCount = 0;
    public static int fiveLuckyCount = 0;
    public static int bonusLuckyCount = 0;
    public static int sixLuckyCount = 0;
    public static int amount = 0;
    public static int cashAmount = 0;

    public static void gameStart(){
        Print.viewGameStart();
        String cash = Input.input();
        Check.checkCach(cash);
        Lotto.myLotto(cash);
        cashAmount = Integer.parseInt(cash);
        luckyNumber = Lotto.getLuckyNumber();
        int bonus = Lotto.getBonusNumber();

    }


    public static void myAutoLotto(int myLottoCount){
        Print.viewUserLottoCount(myLottoCount);
        for(int i=0;i<myLottoCount;i++){
            List<Integer> getNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            autoNumber.add(getNumber);
        }
        Print.viewAutoLotto(autoNumber);
    }

}
