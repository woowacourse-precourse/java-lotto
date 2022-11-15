package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String LINE = System.lineSeparator();
    private static final String STATISTICS_MESSAGE = LINE + "당첨 통계" + LINE + "---";
    private static final String STATISTICS_THREE_MATCH = "3개 일치 (5,000원) - %d개";
    private static final String STATISTICS_FOUR_MATCH = LINE + "4개 일치 (50,000원) - %d개";
    private static final String STATISTICS_FIVE_MATCH = LINE + "5개 일치 (1,500,000원) - %d개";
    private static final String STATISTICS_FIVE_MATCH_ONE_BONUS = LINE + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String STATISTICS_SIX_MATCH = LINE + "6개 일치 (2,000,000,000원) - %d개";
    private static final String OUTPUT_PURCHASE = LINE + "%d개를 구매했습니다." + LINE;
    private static final String OUTPUT_EARNING = LINE + "총 수익률은 %.1f%%입니다.";
    private static final String LOTTO_OPEN = "[";
    private static final String LOTTO_CLOSE = "]";
    private static final String COMMA_AND_SPACE = ", ";

    public void printPurchaseCount(int lottoCount){
        System.out.printf(OUTPUT_PURCHASE,lottoCount);
    }

    public void printStatistics(List<Integer> lottoStatistics){
        System.out.println(STATISTICS_MESSAGE);
        System.out.printf(STATISTICS_THREE_MATCH, lottoStatistics.get(0));
        System.out.printf(STATISTICS_FOUR_MATCH, lottoStatistics.get(1));
        System.out.printf(STATISTICS_FIVE_MATCH, lottoStatistics.get(2));
        System.out.printf(STATISTICS_FIVE_MATCH_ONE_BONUS, lottoStatistics.get(3));
        System.out.printf(STATISTICS_SIX_MATCH, lottoStatistics.get(4));
    }

    public void printEarning(double earning){
        System.out.printf(OUTPUT_EARNING,earning);
    }

    public void printLottoNumbers(Lotto lotto) {
        StringBuilder result = new StringBuilder(LOTTO_OPEN);
        for (int lottoNumber : lotto.get()) {
            result.append(lottoNumber).append(COMMA_AND_SPACE);
        }
        result.delete(result.length() - 2, result.length()).append(LOTTO_CLOSE);
        System.out.println(result);
    }

}
