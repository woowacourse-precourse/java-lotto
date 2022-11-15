package lotto;

import java.util.*;
import static lotto.UserInputException.*;

public class User {
    private int money;
    private int earnMoney;
    private int bonusNumber;
    private final List<Integer> winningNumbers;
    private final Map<String, Integer> result;

    public User() {
        this.money = -1;
        this.bonusNumber = -1;
        this.winningNumbers = new ArrayList<>();
        this.result = new LinkedHashMap<>();
        for (String rankI : new String[]{"FIFTH", "FORTH", "THIRD", "SECOND", "FIRST"}) {
            result.put(rankI, 0);
        }
    }

    public void updateResult(String rank) {
        this.result.replace(rank, this.result.get(rank) + 1);
    }

    public boolean setMoney(String moneyInput) {
        if (numberCheck(moneyInput)) return true;
        if (moneyMinCheck(moneyInput)) return true;
        if (moneyUnitCheck(moneyInput)) return true;;

        this.money = Integer.parseInt(moneyInput);

        return false;
    }

    public int getMoney() {
        return this.money;
    }

    public boolean setWinningNumbers(String winningNumbersInput) {
        if (delimiterCheck(winningNumbersInput)) return true;
        if (lengthCheck(winningNumbersInput, 6)) return true;
        if (rangeCheck(winningNumbersInput)) return true;
        if (duplicateCheck(winningNumbersInput)) return true;

        String[] validatedInput = winningNumbersInput.split(",");
        for (String inputI : validatedInput) {
            winningNumbers.add(Integer.parseInt(inputI));
        }

        return false;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public boolean setBonusNumber(String bonusNumberInput) {
        if (lengthCheck(bonusNumberInput, 1)) return true;
        if (rangeCheck(bonusNumberInput)) return true;
        if (duplicateBonusCheck(this.winningNumbers, bonusNumberInput)) return true;

        this.bonusNumber = Integer.parseInt(bonusNumberInput);

        return false;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void calculateProfit() {
        this.earnMoney = 0;
        for (String rankI : this.result.keySet()) {
            if (this.result.get(rankI) == 0) continue;
            this.earnMoney += this.result.get(rankI) * Rank.valueOf(rankI).getMoney();
        }
    }

    public void informProfit() {
        String profitRatio = String.format("%.1f", (double) this.earnMoney / this.money * 100);
        System.out.printf("총 수익률은 %s%%입니다.", profitRatio);
    }

    public void informResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (String rankI : this.result.keySet()) {
            String resultI = String.format(Rank.valueOf(rankI).getInfo(), this.result.get(rankI));
            System.out.println(resultI);
        }
    }

}
