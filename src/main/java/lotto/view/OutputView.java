package lotto.view;

import lotto.constant.Rank;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASE_DETAILS_OUTPUT_MESSAGE = "개를 구매했습니다.";
    private static final String RATE_OF_RETURN_OUTPUT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String WINNING_STATISTICS_OUTPUT_MESSAGE = "당첨 통계\n---";

    public void printPurchaseDetails(List<Lotto> lottoTickets) {
        int numberOfTickets = lottoTickets.size();
        System.out.println(numberOfTickets + PURCHASE_DETAILS_OUTPUT_MESSAGE);
        for(Lotto lottoTicket : lottoTickets){
            printLottoTicket(lottoTicket);
        }
    }

    private void printLottoTicket(Lotto lottoTicket){
        String result = "[";
        List<Integer> numbers = lottoTicket.getNumbers();
        int lastIndex = numbers.size()-1;
        for(int i = 0; i <= lastIndex; i++){
            result += numbers.get(i);
            if(i != lastIndex){
                result += ", ";
            }
        }
        result += "]";
        System.out.println(result);
    }

    public void printRateOfReturn(double rateOfReturn){
        System.out.printf(RATE_OF_RETURN_OUTPUT_FORMAT, rateOfReturn);
        System.out.print("\n");
    }

    public void printWinningStatistics(Map<Rank, Integer> winningStatistics){
        System.out.println(WINNING_STATISTICS_OUTPUT_MESSAGE);
        for(int i = 0; i < winningStatistics.size(); i++){
            Rank rank = Rank.get(i);
            if(rank.condition().equals("꽝")){
                continue;
            }
            String output = rank.condition() + " (" + rank.printingFormatOfAmount() + ") - " + winningStatistics.get(rank) + "개";
            System.out.println(output);
        }
    }
}
