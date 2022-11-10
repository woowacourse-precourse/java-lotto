package lotto;

import lotto.UserInput.InputDomain;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchase_amount;
        int bonus_number;
        List<Integer> winning_lottery_number;
        UserLottery user_lotto;
        Lotto winning_lotto;
        WinningStatistics winningStatistics;

        purchase_amount= InputDomain.purchaseAmountInput();
        user_lotto=new UserLottery(purchase_amount);
        winning_lottery_number = InputDomain.winningLotteryInput();
        winning_lotto = new Lotto(winning_lottery_number);
        bonus_number = InputDomain.bonusNumberInput(winning_lottery_number);
        winningStatistics=new WinningStatistics(user_lotto.getUserLotterys(),winning_lotto.getNumbers(),bonus_number,purchase_amount);
    }
}
