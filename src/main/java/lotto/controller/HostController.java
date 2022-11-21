package lotto.controller;



import static lotto.controller.ExceptionHandler.excParseInt;
import static lotto.controller.ExceptionHandler.validNumberRange;
import static lotto.controller.ExceptionHandler.validWinningForm;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Host;
import lotto.view.HostUI;

public class HostController {
    private static Host model;
    private final static HostUI view = new HostUI();

    public void makeWinning(){

        List<Integer> numbers = new ArrayList<>(makeNumbers());

        int bonus = makeBonus();


        model = new Host(numbers, bonus);
    }

    public List<Integer> makeNumbers(){
        String winning = view.getWinningNumbers();
        validWinningForm(winning);
        return convetWinningToNumbers(winning);
    }

    public int makeBonus(){
        int bonus = excParseInt(view.getBonusNumber());
        validNumberRange(bonus);

        return bonus;
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

        if(hit == 5.0 && lottery.contains(model.bonusNumber())){
            hit += 0.5;
        }

        return hit;
    }
}
