package lotto;

import constance.Texts;

import java.util.List;

import static constance.Texts.LOTTO_USER_PURCHASE_RESULT;

public class Game {

    private final Checker checker = new Checker();
    private User user;
    private WinningLotto winningLotto;
    public void run(){
        this.play();
    }

    public void play(){

        String amount;
        String numbers;
        String bonusNumber;
        int checkedAmount;
        List<Integer> checkedNumbers;
        int checkedBonusNumber;

        System.out.println(Texts.LOTTO_USER_INPUT_PURCHASE_AMOUNT);
        amount = camp.nextstep.edu.missionutils.Console.readLine();

        checkedAmount=checker.checkAmountInput(amount);

        user=new User(checkedAmount);

        System.out.println();
        System.out.println(String.format(LOTTO_USER_PURCHASE_RESULT,user.getLotteryCount(),user.getLotteryList()));

        System.out.println(Texts.LOTTO_USER_INPUT_WINNING_NUMBERS);
        numbers = camp.nextstep.edu.missionutils.Console.readLine();

        checkedNumbers = checker.checkNumbersInput(numbers);

        System.out.println();
        System.out.println(Texts.LOTTO_USER_INPUT_BONUS_NUMBERS);
        bonusNumber = camp.nextstep.edu.missionutils.Console.readLine();

        checkedBonusNumber=checker.checkNumber(bonusNumber);

        winningLotto=new WinningLotto(checkedNumbers,checkedBonusNumber);

        System.out.println("!--Test: "+winningLotto);

        System.out.println();
        System.out.println(Texts.LOTTO_GAME_WINNING_STATS);

    }
}
