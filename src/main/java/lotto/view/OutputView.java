package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_DETAILS_OUTPUT_MESSAGE = "개를 구매했습니다";

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
}
