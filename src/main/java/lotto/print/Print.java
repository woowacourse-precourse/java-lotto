package lotto.print;

import java.util.List;
import java.util.Map;

public class Print {
    final static String PURCHASE_GUIDE = "개를 구매했습니다.";
    final static String COUNT_UNIT = "개";
    final static String RATE_OF_RETURN_GUIDE_FRONT = "총 수익률은 ";
    final static String RATE_OF_RETURN_GUIDE_BACK = "%입니다.";

    public static void sendError(Object obj) {
        System.out.println(ErrorMessage.sendMessage(obj));
    }//sendError

    public static void sendPurchaseMessage(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_GUIDE);
    }//sendPurchaseMessage

    public static void sendMultipleTicketsGuide(List<List<Integer>> multipleTickets) {
        for (List<Integer> ticket : multipleTickets) {
            System.out.println(ticket.toString());
        }//for
    }//sendMultipleTicketsGuide

    public static void sendStatisticsMessage(Map<String, Integer> statistics) {
        System.out.println(StatisticsMessage.sendMessage("guide"));

        for (int rank = 5; 0 < rank; rank--) {
            String message = StatisticsMessage.sendMessage(rank + "등")
                    + statistics.get(rank + "등") + COUNT_UNIT;
            System.out.println(message);
        }//for
    }//sendStatisticsMessage

    public static void sendRateOfReturnMessage(double rateOfReturn) {
        System.out.println(RATE_OF_RETURN_GUIDE_FRONT + rateOfReturn + RATE_OF_RETURN_GUIDE_BACK);
    }//sendRateOfReturnMessage
}//end class
