package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Input;
import lotto.check.Check;
import lotto.check.Validator;
import lotto.domain.Lotto;
import lotto.view.Print;

import java.util.*;
public class Game {
    public static List<List<Integer>> autoNumber = new ArrayList<>();
    public static List<Integer> luckyNumber = new ArrayList<>();
    public static int cashAmount = 0;
    public static int bonus = 0;


    public static void gameStart() {
        inputPrice();
        inputLuckyNumber();
        inputBonusNumber();

        Check.compareLucky(luckyNumber,bonus);

        Check.printResult();
    }

    public static void inputBonusNumber(){
        Print.viewInputBonusNubmer();
        bonus = Lotto.getBonusNumber();
    }
    public static void inputLuckyNumber(){
        Print.viewInputLuckyNumber();
        luckyNumber = Lotto.getLuckyNumber();
    }
    public static void inputPrice(){
        Print.viewGameStart();
        String cash = Input.input();
        Validator.validateCash(cash);
        Lotto.myLotto(cash);
        cashAmount = Integer.parseInt(cash);
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
