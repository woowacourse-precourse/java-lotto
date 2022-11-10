package lotto;

import lotto.UserInput.Input_domain;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchase_lottery_count;
        int bonus_number;
        List<Integer> winning_lottery_number;
        UserLottery user_lotto;
        Lotto winning_lotto;

        purchase_lottery_count=Input_domain.purchaseAmountInput();
        user_lotto=new UserLottery(purchase_lottery_count);
        winning_lottery_number = Input_domain.winningLotteryInput();
        winning_lotto = new Lotto(winning_lottery_number);
        bonus_number = Input_domain.bonusNumberInput(winning_lottery_number);
    }
}
