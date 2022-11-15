package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGenerator generator = new LottoGenerator();
        LotteryCompare compare = new LotteryCompare();

        try {
            int userAccount = generator.howManyLotto(generator.inputMoney());
            List<List> userList = generator.makeLottery(userAccount);
            List<Integer> winningNumberList = generator.inputNumber();
            Integer bonusNumber = generator.bonusNumber();
            List<List> result = compare.compareNumbers(userList, winningNumberList, bonusNumber);
            List<Integer> prizeResult = compare.countWinResult(result);
            compare.printPrize(prizeResult);
            compare.getPrizeMoney(prizeResult, userAccount);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

