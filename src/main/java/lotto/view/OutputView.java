package lotto.view;

import lotto.model.WinningNumberStatus;
import lotto.model.Lotto;
import java.util.HashMap;
import java.util.List;

import static lotto.model.NoticeMessage.ADDITIONAL_SECOND;
import static lotto.model.NoticeMessage.LOTTO_COUNT;

public class OutputView {

    public void outputLotto(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + LOTTO_COUNT.toString());
        for (Lotto lottery : lotteries) {
            System.out.println(lottery.getNumbers());
        }
        System.out.println();
    }

    public void outputWinningStatistics(HashMap<Integer, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int rank = WinningNumberStatus.FIFTH.getOrder(); rank >= WinningNumberStatus.FIRST.getOrder(); rank--) {
            WinningNumberStatus winningNumberStatus = WinningNumberStatus.getWinningNumberStatusByOrder(rank);
            System.out.println(winningNumberStatus.getCount() + "개 일치" + getAdditionalSecondNotice(rank)
                    + " (" + getProcessedMoney(winningNumberStatus.getMoney())+ "원) - " + result.get(rank) + "개");
        }
    }

    private String getProcessedMoney(int money) {
        String interimMoney = String.valueOf(money);
        int limit = 3;
        int count = 0;

        StringBuilder processedMoney = new StringBuilder();
        for (int index = interimMoney.length(); index > 0; index--) {
            if (count == limit) {
                processedMoney.append(",");
                count = 0;
                index++;
                continue;
            }

            processedMoney.append(interimMoney.charAt(index - 1));
            count++;
        }
        return processedMoney.reverse().toString();
    }

    private String getAdditionalSecondNotice(int rank) {
        if (rank == WinningNumberStatus.SECOND.getOrder()) {
            return ADDITIONAL_SECOND.toString();
        }
        return "";
    }

    public void outputEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }

}
