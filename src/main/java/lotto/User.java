package lotto;

import java.util.*;

public class User {
    private int money;
    private int bonusNumber;
    private List<Integer> winningNumbers;
    private Map<String, Integer> result;

    public User() {
        this.money = -1;
        this.bonusNumber = -1;
        this.winningNumbers = new ArrayList<>();
        this.result = new LinkedHashMap<>();
        for (String rankI : new String[]{"FIRST", "SECOND", "THIRD", "FORTH", "FIFTH"}) {
            result.put("FIRST", 0);
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
}
