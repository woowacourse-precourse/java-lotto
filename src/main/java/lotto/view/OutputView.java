package lotto.view;

import lotto.constants.GuideMessage;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.ScoreAndRank;
import lotto.model.ScoreBoard;

import java.util.List;
import java.util.Map;

import static lotto.constants.GuideMessage.*;

public class OutputView {

    public static void printUserLotto(List<Lotto> lottoNumbers) {
        System.out.println(lottoNumbers.size() + PURCHASE_MESSAGE);
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLotto());
        }
    }

    public static void printRank(ScoreBoard scoreBoard) {
        Map<String, Integer> ranks = scoreBoard.getRankAndScore();

        System.out.println(RANK_STATS);
        System.out.println(BAR);
        for (String rank : ranks.keySet()) {
            System.out.println(Rank.valueOf(rank).getMatchMessage() + ranks.get(rank)+"개");
        }
    }

    public static void printPercentage(double percent) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", percent);
    }
}
