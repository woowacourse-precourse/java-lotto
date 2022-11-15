package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.Constants.*;

public class UI {
    private int cost;
    private List<Integer> winningNumbers;
    private int bonus;

    public UI() {
        this.winningNumbers = new ArrayList<>();
    }

    public int getCost() {
        return cost;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }

    public void inputCost() {
        System.out.println(INPUT_COST.getValue());
        this.cost = Integer.parseInt(readLine());
        System.out.println();
    }

    public void inputWinning() {
        System.out.println(INPUT_WINNING_NUMBERS.getValue());
        String[] winning = readLine().split(",");
        for (int i = 0; i < winning.length; i++) {
            winningNumbers.add(Integer.parseInt(winning[i]));
        }
        System.out.println();
    }

    public void inputBonus() {
        System.out.println(INPUT_BONUS_NUMBERS.getValue());
        this.bonus = Integer.parseInt(readLine());
        System.out.println();
    }

    public void showCostCount() {
        System.out.print(this.cost / 1000);
        System.out.println(SHOW_COST_COUNT.getValue());
    }

    public void showLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> list : lottoNumbers) {
            System.out.println(list.toString());
        }
        System.out.println();
    }

    public void showWinning(int first, int second, int third, int fourth, int fifth) {
        System.out.println(SHOW_WINNING.getValue());
        System.out.println(SHOW_WINNING_LINE.getValue());
        System.out.println(SHOW_WINNING_FIFTH.getValue()+fifth+SHOW_WINNING_UNIT.getValue());
        System.out.println(SHOW_WINNING_FOURTH.getValue()+fourth+SHOW_WINNING_UNIT.getValue());
        System.out.println(SHOW_WINNING_THIRD.getValue()+third+SHOW_WINNING_UNIT.getValue());
        System.out.println(SHOW_WINNING_SECOND.getValue()+second+SHOW_WINNING_UNIT.getValue());
        System.out.println(SHOW_WINNING_FIRST.getValue()+first+SHOW_WINNING_UNIT.getValue());
    }

    public void showYield(float yield) {
        System.out.println(SHOW_YIELD.getValue()+yield+SHOW_YIELD_PERCENT.getValue());
    }
}
