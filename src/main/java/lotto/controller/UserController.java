package lotto.controller;

import lotto.Prize;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.service.InputService;
import lotto.service.OutputService;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UserController {

    private final InputService inputService = new InputService();
    private final OutputService outputService = new OutputService();

    public int requestMoney() {
        outputService.requestMoney();
        Money money = inputService.requestMoney();
        return money.getMoney();
    }

    public List<Integer> requestWinningNumber() {
        outputService.requestWinningNumber();
        WinningNumber winningNumber = inputService.requestWinningNumber();
        return winningNumber.getWinningNumber();
    }

    public int requestBonusNumber() {
        outputService.requestBonusNumber();;
        BonusNumber bonusNumber = inputService.requestBonusNumber();
        return bonusNumber.getNumber();
    }

    public void printResult(HashMap<String, Integer> prizes, int money) {
        outputService.printPerior();
        int total = 0;
        for (Prize prize : Prize.values()) {
            if (prize.getIndex() != "5") {
                outputService.printPrize(prize.getSameAmount(), (prize.getReward()), prizes.get(prize.getIndex()));
            }
            if (prizes.get(prize.getIndex()) > 0)
                total += prize.getReward();
        }
        outputService.getRate(total, money);
    }

}
