package lotto;

import constance.Texts;

import java.util.List;

public class User {

    private Checker checker;
    private List<Lotto> lotteries;
    private List<List<Result>> results;
    private int lotteryCount;
    private int winnings;

    public User(){
        checker=new Checker();
        System.out.println(Texts.LOTTO_USER_INPUT_PURCHASE_AMOUNT);
        setAmount();
    }
    private void setAmount(){
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        checker.checkAmountInput(input);
    }

}
