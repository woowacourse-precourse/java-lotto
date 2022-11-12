package lotto.domain;

import lotto.Game;
import lotto.Input;
import lotto.check.Check;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void myLotto(String cash){
        int myLottoCount = Integer.parseInt(cash) / Check.UNIT;
        Game.myAutoLotto(myLottoCount);
    }

    public static List<Integer> makeLuckyNumber(String luckyNumber){
        List<Integer> luckyBall = new ArrayList<>();
        String[] luckyArr = luckyNumber.split(",");
        for(int i=0;i<luckyArr.length;i++){
            luckyBall.add(Integer.parseInt(luckyArr[i]));
        }
        Lotto lotto = new Lotto(luckyBall);
        return luckyBall;
    }
    public static List<Integer> getLuckyNumber(){
        String luckyNumber = Input.input();
        List<Integer> luckyBall = makeLuckyNumber(luckyNumber);
        return luckyBall;
    }
    public static int getBonusNumber(){
        String bonusNumber = Input.input();
        Check.checkBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
