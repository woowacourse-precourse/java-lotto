package lotto.service;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.*;

public class LottoService {
    private final List<LottoRanking> rankingList = new ArrayList<>(Arrays.asList(LottoRanking.values()));

    public List<GenerateNumbers> generateLotteries(int count) {

        List<GenerateNumbers> generateLotteries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            GenerateNumbers generateNumbers = new GenerateNumbers();
            generateLotteries.add(generateNumbers);
        }

        return generateLotteries;
    }

    public void printLotteries(List<GenerateNumbers> generateLotteries) {
        List<String> lotteries = generateLotteriesToString(generateLotteries);

        for (String lotto : lotteries) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    private List<String> generateLotteriesToString(List<GenerateNumbers> generateLotteries) {
        List<String> lotteries = new ArrayList<>();

        for (GenerateNumbers numbers : generateLotteries) {
            StringBuffer stringBuffer = new StringBuffer(sortList(numbers).toString());
            lotteries.add(stringBuffer.toString());
        }

        return lotteries;
    }

    private List<Integer> sortList(GenerateNumbers generateNumbers) {
        List<Integer> sortNum = generateNumbers.getGenerateNumbers();
        Collections.sort(sortNum);

        return sortNum;
    }

    public int calculatorProfit(List<LottoRanking> lottoRankings) {
        int profit = 0;

        for (int i = 0; i < lottoRankings.size(); i++) {
            profit += lottoRankings.get(i).getReward();
        }

        return profit;
    }

    public void printPlace(List<LottoRanking> lottoRankings) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = rankingList.size() - 2; i >= 0; i--) {
            LottoRanking lottoRank = rankingList.get(i);
            if (lottoRank == LottoRanking.SECOND_PLACE && lottoRank != LottoRanking.LOSING) {
                System.out.println(lottoRank.getMatches() + "개 일치, 보너스 볼 일치 ("
                        + decFormat.format(lottoRank.getReward()) + "원) - " + Collections.frequency(lottoRankings, lottoRank) + "개");
            } else if (lottoRank != LottoRanking.LOSING) {
                System.out.println(lottoRank.getMatches() + "개 일치 ("
                        + decFormat.format(lottoRank.getReward()) + "원) - " + Collections.frequency(lottoRankings, lottoRank) + "개");
            }
        }
    }


    public List<LottoRanking> ranking(List<GenerateNumbers> generateLotteries, List<Integer> playerNum, int bonusNum) {

        WinJudgment winJudgment = new WinJudgment();
        List<LottoRanking> lottoRankings = new ArrayList<>();

        for (GenerateNumbers generateLotto : generateLotteries) {
            int matchNum = winJudgment.matchNumbers(generateLotto.getGenerateNumbers(), playerNum);
            boolean matchBonus = winJudgment.matchBonusNumber(generateLotto.getGenerateNumbers(), bonusNum);
            lottoRankings.add(winJudgment.rankingJudgment(matchNum, matchBonus));
        }

        return lottoRankings;
    }

}
