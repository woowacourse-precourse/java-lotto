package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    final static String INFORMATION_INPUT_MONEY = "구입 금액을 입력해 주세요.";
    public static void main(String[] args) {
        // TODO: 로또 공장 관련 기능 구현
        LotteryFactory lotteryFactory = new LotteryFactory();

        // TODO: 복권 살 돈 지급
        System.out.println(INFORMATION_INPUT_MONEY);
        String inputMoney = Console.readLine();
        Integer money = lotteryFactory.checkMoney(inputMoney);

        // TODO: 로또 티켓 발급받기
        List<Lotto> lotteryTickets = lotteryFactory.getLotteryTicket(money);
        lotteryFactory.printLotteryNumber(lotteryTickets);

        // TODO: 당첨 번호 입력받기
        List<Integer> numbers = lotteryFactory.getWinningNumber();
        // TODO: 보너스 번호 입력받기
        Integer bonusNumber = lotteryFactory.getBonusNumber();

        // TODO: 당첨 확인하기
        WinningNumber winningNumber = new WinningNumber(numbers, bonusNumber);
        lotteryFactory.CompareLotteryNumbersAndWinningNumbers(winningNumber, lotteryTickets);
        lotteryFactory.printWinningStats(money);
    }
}
