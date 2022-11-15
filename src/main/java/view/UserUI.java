package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.EnumMap;
import model.Prize;

public class UserUI {

    private static final String purchaseMessage = "구입금액을 입력해 주세요.";
    private static final String[] earningsMessage = {"총 수익률은 ", "%입니다."};

    public String getPurchaseMoney(){
        System.out.println(purchaseMessage);
        return readLine();
    }

    public void printWinningHistory(Prize[] prizeValues, EnumMap<Prize,Integer> winningHistory){
        for(Prize prize: prizeValues){
            String message = prize.MESSAGE();
            int times = winningHistory.get(prize);
            int length = message.length();

            message = message.substring(0, length-1) + times + message.substring(length-1);

            System.out.println(message);
        }
    }

    public void printEarningsRate(double earningsRate){
        String message = earningsMessage[0] + earningsRate + earningsMessage[1];
        System.out.println(message);
    }

    public void printLotteryResult(Prize[] prizeValues,EnumMap<Prize, Integer> winningHistory, double earningsRate){
        printWinningHistory(prizeValues, winningHistory);
        printEarningsRate(earningsRate);
    }
}
