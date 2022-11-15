package lotto.view;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class Output {

    private static final String LOTTO_PAPER_COUNT_MASSAGE = "개를 구매했습니다.";
    private static final String PAPER_COUNT_MASSAGE = "당첨 통계\n---";
    private static final String WINNIG_BALL_MATCHING_MASSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String WINNIG_AND_BONUS_BALL_MATCHING_MASSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String FINAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printLottoPaperCount(int count) {
        System.out.println(count + LOTTO_PAPER_COUNT_MASSAGE);
    }

    public void printLottoPapers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printResult(Map<Rank, Integer> result){
        System.out.println(PAPER_COUNT_MASSAGE);
        for
    }

    public void printProfit(double profit) {

    }

}
