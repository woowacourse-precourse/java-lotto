package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.EnumMap;
import java.util.List;
import model.Prize;

public class UserUI {

    private static final String lotteriesMessage = "개를 구매했습니다.";
    private static final String purchaseMessage = "구입금액을 입력해 주세요.";
    private static final String[] earningsMessage = {"총 수익률은 ", "%입니다."};
    private static final String resultMessage = "당첨 통계\n---";

    public String getPurchaseMoney(){
        System.out.println(purchaseMessage);
        return readLine();
    }

    public void printWinningHistory(List<String> messages, List<Integer> winningTimes){
        for(int idx = 0; idx<messages.size(); idx++){
            String message = messages.get(idx);
            int times = winningTimes.get(idx);
            int length = message.length();

            message = message.substring(0, length-1) + times + message.substring(length-1);

            System.out.println(message);
        }
    }

    public void printEarningsRate(double earningsRate){
        String message = earningsMessage[0] + earningsRate + earningsMessage[1];
        System.out.println(message);
    }

    public void printLotteryResult(List<String> messages, List<Integer> winningTimes, double earningsRate){
        System.out.println(resultMessage);
        printWinningHistory(messages, winningTimes);
        printEarningsRate(earningsRate);
    }

    public void printLotteries(List<List<Integer>> lotteries){
        int count = lotteries.size();
        System.out.println(count+lotteriesMessage);
        for(List<Integer> lottery: lotteries){
            LottoUI.printLottey(lottery);
        }
    }
}
