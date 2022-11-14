package lotto.simulation;

import lotto.display.Display;
import lotto.function.Function;
import lotto.function.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simulation {
    private static int prices = 0;
    private static List<Lotto> trial = List.of();
    private static List<Integer> winNumber = List.of();
    private static int bonus = 0;
    private static final List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

    public static void simulateLotto() {
        String price = Function.getMoney();
        if (Function.validPrice(price)) {
            buyLotto(price);
        }
    }

    private static void buyLotto(String price) {
        prices = Integer.parseInt(price);
        trial = Function.purchaseLotto(prices);
        Display.displayLotto(trial);
        getWinNumber();
    }

    private static void getWinNumber() {
        String[] winNumbers = Function.getWinningNumber();
        if (Function.validWinningNumberInput(winNumbers)) {
            winNumber = Function.changeTypeofWinningNumber(winNumbers);
            if (Function.validWinningNumberCount(winNumber) && Function.validWinningNumberRange(winNumber)) {
                getBonus();
            }
        }
    }

    private static void getBonus() {
        String bonus_s = Function.getBonus();
        if (Function.validBonus(bonus_s, Simulation.winNumber)) {
            bonus = Integer.parseInt(bonus_s);
            getResult();
        }
    }

    private static void getResult() {
        for (Lotto lotto : trial) {
            int count = Function.countMatching(lotto, winNumber, bonus);
            List<Integer> temp_result = Function.winLotto(count);
            for (int j = 0; j < 5; j++) {
                result.set(j, result.get(j) + temp_result.get(j));
            }
        }
        Display.displayResult(result);
        String yield = Function.calculateYield(prices, Function.calculateWinning(result));
        Display.displayYield(yield);
    }
}
