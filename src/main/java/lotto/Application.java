package lotto;

import lotto.UserInput.Input_domain;

import java.util.*;

public class Application {
    private static List<Integer> winning_lottery_number;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int bonus_number;
        Input_domain.purchaseAmountInput();
        winning_lottery_number = Input_domain.winningLotteryInput();
        bonus_number = Input_domain.bonusNumberInput(winning_lottery_number);
        Lotto lotto = new Lotto(winning_lottery_number);
        lotto.setBounusNumber(bonus_number);
    }
}
