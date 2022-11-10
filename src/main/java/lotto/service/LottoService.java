package lotto.service;

import lotto.domain.*;

import java.util.*;

public class LottoService {
    private UserService userService;
    private final List<LottoRanking> rankingList = new ArrayList<>(Arrays.asList(LottoRanking.values()));

    public List<GenerateNumbers> generateLotteries(int count) {

        List<GenerateNumbers> generateLotteries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            GenerateNumbers generateNumbers = new GenerateNumbers();
            generateLotteries.add(generateNumbers);
        }

        return generateLotteries;
    }

    public List<Integer> sortList(List<Integer> numbers) {
        Collections.sort(numbers);

        return numbers;
    }

    public void calculatorProfit(List<LottoRanking> lottoRankings) {
        int profit = 0;
        float profitPercent = 0L;

        for (int i = 0; i < lottoRankings.size(); i++) {
            profit += lottoRankings.get(i).getReward();
        }

        profitPercent = profit / userService.getMoney();

        System.out.printf("총 수익률은 .1f%입니다.\n", profitPercent);
    }

    public void printPlace(List<LottoRanking> lottoRankings) {
        List<Integer> placePrize = eachSumPlacePrize(lottoRankings);

        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = rankingList.size() - 2; i <= 0; i--) {
            LottoRanking lottoRank = rankingList.get(i);
            if (lottoRank != LottoRanking.SECOND_PLACE && lottoRank != LottoRanking.LOSING) {
                System.out.println(lottoRank.getMatches() + "개 일치 (" + placePrize.get(i) + "원) - "
                        + Collections.frequency(lottoRankings, lottoRank) + "개");
            }
            System.out.println(lottoRank.getMatches() + "개 일치, 보너스 볼 일치 (" + placePrize.get(i) + "원) - "
                    + Collections.frequency(lottoRankings, lottoRank) + "개");
        }
    }

    private List<Integer> eachSumPlacePrize(List<LottoRanking> lottoRankings) {
        List<Integer> placePrize = new ArrayList<>();

        for (LottoRanking place : rankingList) {
            placePrize.add(place.getReward() * Collections.frequency(lottoRankings, place));
        }

        return placePrize;
    }

    private List<LottoRanking> ranking(List<GenerateNumbers> generateLotteries, List<Integer> playerNum, int bonusNum) {

        WinJudgment winJudgment = new WinJudgment();
        List<LottoRanking> lottoRankings = new ArrayList<>();

        for (GenerateNumbers generateLotto : generateLotteries) {
            int matchNum = winJudgment.matchNumbers(generateLotto.getGenerateNumbers(), playerNum);
            boolean matchBonus = winJudgment.matchBonusNumber(generateLotto.getBonusNumber(), bonusNum);
            lottoRankings.add(winJudgment.rankingJudgment(matchNum, matchBonus));
        }

        return lottoRankings;
    }


}
