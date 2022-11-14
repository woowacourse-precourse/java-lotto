package lotto;

import java.util.Collections;
import java.util.List;

public class Detail {
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String NUMBER3_RESULT_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String NUMBER4_RESULT_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String NUMBER5_RESULT_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String NUMBER5_ADD_BONUST_RESULT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String NUMBER6_RESULT_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String TAIL_MESSAGE = "개";
    private static final String TOTAL_YIELD_FRONT_MESSAGE = "총 수익률은 ";
    private static final String TOTAL_YIELD_BACK_MESSAGE = "%입니다.";

    public static int[] output = new int[5];
    public double yield;
    public int[] winningAmount = new int[]{5000, 50000, 1500000, 30000000, 2000000000};

    public void showOutput() {
        int num = 5;
        double percentage = 55.5;
        System.out.println(RESULT_MESSAGE);
        System.out.println(NUMBER3_RESULT_MESSAGE + output[0] + TAIL_MESSAGE);
        System.out.println(NUMBER4_RESULT_MESSAGE + output[1] + TAIL_MESSAGE);
        System.out.println(NUMBER5_RESULT_MESSAGE + output[2] + TAIL_MESSAGE);
        System.out.println(NUMBER5_ADD_BONUST_RESULT_MESSAGE + output[3] + TAIL_MESSAGE);
        System.out.println(NUMBER6_RESULT_MESSAGE + output[4] + TAIL_MESSAGE);
        System.out.println(TOTAL_YIELD_FRONT_MESSAGE + yield + TOTAL_YIELD_BACK_MESSAGE);

    }

    public void showLottoTickets(List<List<Integer>> tickets) {

        for (int i = 0; i < tickets.size(); i++) {
            Collections.sort(tickets.get(i));
            System.out.println(tickets.get(i).toString());
        }
    }

    public void compareLottoNumbers(List<Integer> winnerNumber, int bonusNumber, List<List<Integer>> tickets) {


        for (int i = 0; i < tickets.size(); i++) {
            compareNumber(winnerNumber, bonusNumber, tickets.get(i));
        }
        yieldCalculate(tickets.size());
        showOutput();

    }

    public void yieldCalculate(int quantity) {
        double sum = 0.0;
        for (int i = 0; i < output.length; i++) {
            sum += output[i] * winningAmount[i];
        }
        double value = quantity * 1000.0;
        yield = sum / value * 100.0;
    }

    public void compareNumber(List<Integer> winnerNumber, int bonusNumber, List<Integer> userNumber) {
        int count = 0;

        for (int i = 0; i < winnerNumber.size(); i++) {
            if (winnerNumber.contains(userNumber.get(i))) {
                count++;
            }
        }
        if (count == 6) {
            output[count - 2]++;
        }
        if (count != 6 && count >= 3) {
            output[count - 3]++;
            if (count == 5) {
                compareBonusNumber(bonusNumber, userNumber);
            }
        }

    }

    public void compareBonusNumber(int bonusNumber, List<Integer> userNumber) {
        if (userNumber.contains(bonusNumber)) {
            output[3]++;
            output[2]--;
        }
    }
}
