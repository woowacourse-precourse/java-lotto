package lotto.simulation;

import lotto.display.Display;
import lotto.function.Function;
import lotto.function.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private static int prices = 0;

    public static void simulateLotto(){
        List<Lotto> trial = buyLotto();
        Display.displayLotto(trial);
        List<Integer> result = getResult(trial);
        Display.displayResult(result);
        String yield = calculateWinning(result);
        Display.displayYield(yield);
    }
    private static List<Lotto> buyLotto(){
        String prices = Function.getMoney();
        int price = Function.validPrice(prices);
        Simulation.prices = price;
        return Function.purchaseLotto(price);
    }

    private static List<Integer> getResult(List<Lotto> trial){
        List<Integer> winNumber = Function.getWinningNumber();
        Function.validWinningNumber(winNumber);
        String bonus_s = Function.getBonus();
        int bonus = Function.validBonus(bonus_s, winNumber);
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (Lotto lotto : trial) {
            List<Integer> temp_result = Function.winLotto(lotto, winNumber, bonus);
            for (int j = 0; j < 5; j++) {
                result.set(j, result.get(j) + temp_result.get(j));
            }
        }
        return result;
    }

    private static String calculateWinning(List<Integer> result){
        int winning = Function.calculateWinning(result);
        return Function.calculateYield(winning, prices);
    }
}
