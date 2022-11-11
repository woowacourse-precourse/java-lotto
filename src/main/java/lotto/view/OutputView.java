package lotto.view;

import lotto.constant.Rank;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASE_DETAILS_OUTPUT_MESSAGE = "개를 구매했습니다";
    private static final String RATE_OF_RETURN_OUTPUT_FORMAT = "총 수익률은 %.1f%%입니다";

    public void printPurchaseDetails(List<Lotto> lottoTickets) {
        int numberOfTickets = lottoTickets.size();
        System.out.println(numberOfTickets + PURCHASE_DETAILS_OUTPUT_MESSAGE);
        for (int i = 0; i < numberOfTickets; i++) {
            printLotto(lottoTickets.get(i));
        }
    }

    private void printLotto(Lotto lotto){
        String result = "[";
        List<Integer> numbers = lotto.getNumbers();
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
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i = 0; i < winningStatistics.size(); i++){
            String output = Rank.get(i).condition() + " (" + Rank.get(i).winningAmount() + "원) - " + winningStatistics.get(Rank.get(i)) + "개";
            System.out.println(output);
        }
    }
}
