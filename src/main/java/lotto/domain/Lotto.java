package lotto.domain;

import lotto.Game;
import lotto.Input;
import lotto.exception.Exception;
import lotto.check.Validator;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Exception.WRONG_RANGE.getExceptionMessage());
        }
    }

    public static void myLotto(String cash){
        int myLottoCount = Integer.parseInt(cash) / Validator.UNIT;
        Game.myAutoLotto(myLottoCount);
    }

    public static List<Integer> makeLuckyNumber(String luckyNumber){
        List<Integer> luckyBall = new ArrayList<>();
        String[] lucky = luckyNumber.split(",");
        for(int i=0;i<lucky.length;i++){
            luckyBall.add(Integer.parseInt(lucky[i]));
        }
        Lotto lotto = new Lotto(luckyBall);
        return luckyBall;
    }
    public static List<Integer> getLuckyNumber(){
        String luckyNumber = Input.input();
        Validator.validateLuckyNumber(luckyNumber);
        List<Integer> luckyBall = makeLuckyNumber(luckyNumber);
        return luckyBall;
    }
    public static int getBonusNumber(){
        String bonusNumber = Input.input();
        Validator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
