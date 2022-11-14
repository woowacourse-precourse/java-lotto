package lotto.service.view;

import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.correctLotto.CorrectLottoNumbers;
import lotto.domain.lotto.correctLotto.Ranking;
import lotto.domain.lotto.correctLotto.Rankings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ViewConsole {

    private static String SIX_CORRECT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static String PLZ_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static String LOTTO_LINE_COUNT = "개를 구매했습니다.";
    private static String PLZ_INPUT_CORRECT_NUMBER = "당첨 번호를 입력해 주세요.";
    private static String PLZ_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static String CORRECT_STATISTICS_COMMENT = "당첨 통계\n ---";
    private static String TOTAL_YIELD_START = "총 수익률은 ";
    private static String TOTAL_YIELD_END = "%입니다.";
    private static String THREE_CORRECT = "3개 일치 (5,000원) - %d개\n";
    private static String FOUR_CORRECT = "4개 일치 (50,000원) - %d개\n";
    private static String FIVE_CORRECT = "5개 일치 (1,500,000원) - %d개\n";
    private static String FIVE_CORRECT_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";

    public static void printInputMoney() {
        System.out.println(PLZ_INPUT_MONEY);
    }

    public static void printLottoLineCount(int count) {
        System.out.println(count + LOTTO_LINE_COUNT);
    }

    public static void printLottoLineDetails(Lottos lottos) {
        List<List<Integer>> lottoDetails = makeLottoDetails(lottos);

        for (List<Integer> details : lottoDetails) {
            System.out.println(details);
        }
    }

    private static List<List<Integer>> makeLottoDetails(Lottos lottos) {
        List<List<Integer>> lottoDetails = new ArrayList<>();

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> sortedDetails = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedDetails);
            lottoDetails.add(sortedDetails);
        }
        return lottoDetails;
    }

    public static void printInputCorrectNumber() {
        System.out.println(PLZ_INPUT_CORRECT_NUMBER);
    }

    public static void printInputBonusNumber() {
        System.out.println(PLZ_INPUT_BONUS_NUMBER);
    }

    public static void printCorrectStaticsList(Lottos lottos, CorrectLottoNumbers combinedCorrectLottoNumbers, Money money) {
        System.out.println(CORRECT_STATISTICS_COMMENT);

        Rankings rankings = calcRankings(lottos, combinedCorrectLottoNumbers);

        printRankingList(Ranking.makeRankingCount(rankings));

        printYieldValue(money, rankings);
    }

    private static Rankings calcRankings(Lottos lottos, CorrectLottoNumbers combinedCorrectLottoNumbers) {
        List<Ranking> rankingList = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            rankingList.add(combinedCorrectLottoNumbers.compareLottoNumber(lotto));
        }
        return new Rankings(rankingList);
    }

    private static void printRankingList(Map<Ranking, Integer> rankingsCount) {
        System.out.printf(THREE_CORRECT, rankingsCount.get(Ranking.FIFTHRANKING)
                .intValue());
        System.out.printf(FOUR_CORRECT, rankingsCount.get(Ranking.FOURTHRANKING)
                .intValue());
        System.out.printf(FIVE_CORRECT, rankingsCount.get(Ranking.THIRDRANKING)
                .intValue());
        System.out.printf(FIVE_CORRECT_WITH_BONUS, rankingsCount.get(Ranking.SECONDRANKING)
                .intValue());
        System.out.printf(SIX_CORRECT, rankingsCount.get(Ranking.FIRSTRANKING)
                .intValue());
    }

    private static void printYieldValue(Money money, Rankings rankings) {
        Result result = new Result(rankings, money);

        System.out.println(TOTAL_YIELD_START + result.getYield() + TOTAL_YIELD_END);
    }
}
