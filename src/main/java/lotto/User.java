package lotto;

import java.util.*;

public class User {
    private int money;
    private int earnMoney;
    private int bonusNumber;
    private List<Integer> winningNumbers;
    private Map<String, Integer> result;

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

    public void setMoney(String money) {
        this.money = Integer.parseInt(money); // TODO : add exception check
    }

    public int getMoney() {
        return this.money;
    }

    public void setWinningNumbers(String userInput) {
        String[] validatedInput = userInput.split(","); // TODO : change to exception check method output
        for (String inputI : validatedInput) {
            winningNumbers.add(Integer.parseInt(inputI));
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber); // TODO : add exception check
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
