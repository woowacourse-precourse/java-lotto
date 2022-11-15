package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            int payMoney = getPayMoney();
            WinningStatistics winningStatistics = new WinningStatistics(payMoney);
            System.out.println(winningStatistics.printLottos());
            Lotto winningLotto = getWinningNumber();
            int bonusNumber = getBonusNumber();
            winningStatistics.setWinningLottos(winningLotto, bonusNumber);
            WinningStatisticsResult winningStatisticsResult = new WinningStatisticsResult(winningStatistics, payMoney);
            System.out.println(winningStatisticsResult.printWinningStatistics());
            System.out.println(winningStatisticsResult.printYield());
        }
        catch (IllegalArgumentException e){
            System.out.println(Message.ILLEGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
        }
    }
    private static int getPayMoney(){
        Input input = new Input();
        System.out.println(Message.REQUEST_PAY_MONEY.getMessage());
        return input.getPayMoney(Console.readLine());
    }

    private static Lotto getWinningNumber(){
        Input input = new Input();
        System.out.println(Message.REQUEST_WINNING_LOTTO.getMessage());
        return input.getWinningNumber(Console.readLine());
    }

    private static int getBonusNumber(){
        Input input = new Input();
        System.out.println(Message.REQUEST_BONUS_NUMBER.getMessage());
        return input.getBonusNumber(Console.readLine());
    }
}
