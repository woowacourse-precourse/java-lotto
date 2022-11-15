package lotto;

import static lotto.ExceptionHandler.excParseInt;
import static lotto.ExceptionHandler.validNumberDupplication;

import java.util.ArrayList;
import java.util.List;
import lotto.ExceptionHandler;

import model.Host;
import model.Lotto;
import view.HostUI;

public class HostController {
    private static Host model;
    private HostUI view;

    public void makeWinning(){
        String winning = view.getWinningNumbers();
        ExceptionHandler.validWinningForm(winning);
        List<Integer> numbers = convetWinningToNumbers(winning);

        int bonus = excParseInt(view.getBonusNumber());
        ExceptionHandler.validNumberRange(bonus);

        validNumberDupplication(bonus, numbers);

        model = new Host(numbers, bonus);
    }

    public List<Integer> convetWinningToNumbers(String winning){
        List<Integer> numbers = new ArrayList<>();
        for(String number: winning.split(",")){
            numbers.add(excParseInt(number));
        }

        return numbers;
    }

    public static double winOrNot(List<Integer> lottery){
        double hit = 0.0;

        for(int num : lottery){
            if(model.winningNumber().contains(num)){
                hit += 1.0;
            }
        }

        if(lottery.contains(model.bonusNumber())){
            hit += 0.5;
        }

        return hit;
    }
}
