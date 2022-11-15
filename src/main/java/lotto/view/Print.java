package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.RankCounter;
import lotto.utils.Rules;

import java.text.DecimalFormat;
import java.util.List;

public class Print {
    private static String MESSAGE_INSERT_MONEY = "구매금액을 입력해 주세요.";
    private static String MESSAGE_LOTTO_COUNT = "개를 구매했습니다.";
    private static String MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해주세요.";
    private static String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해주세요.";
    private static String MESSAGE_RANK_COUNTER_START = "당첨 통계\n---";
    private static String MESSAGE_TOTAL_YIELD = "총 수익률은 %s입니다.";
    private static String FORM_RANK_COUNTER = "%s - %d개\n";

    public static void printInsertMoney() {
        System.out.println(MESSAGE_INSERT_MONEY);
    }

    public static void printLottoList(List<Lotto> lottos) {
        System.out.println(lottos.size() + MESSAGE_LOTTO_COUNT);
        for (int lottoIndex = 0; lottoIndex < lottos.size(); lottoIndex++) {
            printLotto(lottos.get(lottoIndex));
        }
    }

    public static void printLotto(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(lotto.findLottoNumber(0));
        for (int numberIndex = 1; numberIndex < Rules.LOTTO_SIZE.getValue(); numberIndex++) {
            stringBuilder.append(", ");
            stringBuilder.append(lotto.findLottoNumber(numberIndex));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    public static void printWinningNumber() {
        System.out.println();
        System.out.println(MESSAGE_WINNING_NUMBER);
    }

    public static void printBonusNumber() {
        System.out.println();
        System.out.println(MESSAGE_BONUS_NUMBER);
    }

    public static void printRankCounter(RankCounter rankCounter) {
        System.out.println();
        System.out.println(MESSAGE_RANK_COUNTER_START);

        StringBuilder stringBuilder = new StringBuilder();
        List<Rank> sortedRank = Rank.getSortRanks();
        String form;
        Rank rank;
        for (int rankIndex = 1; rankIndex < sortedRank.size(); rankIndex++) {
            rank = sortedRank.get(rankIndex);
            form = String.format(FORM_RANK_COUNTER, rank.getWinningContent(), rankCounter.countRank(rank));
            stringBuilder.append(form);
        }
        System.out.print(stringBuilder.toString());
    }

    public static void printYield(double yield) {
        DecimalFormat yieldFormat = new DecimalFormat("###,###.0%");
        String yieldRound = yieldFormat.format(yield);
        System.out.printf(MESSAGE_TOTAL_YIELD, yieldRound);
        System.out.println();
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
