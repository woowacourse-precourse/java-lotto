package lotto.domain;

import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.LottoResults;

import java.util.List;

public class LottoResult {
    private static String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    LottoProfitRate lottoProfitRate = new LottoProfitRate();

    public void getLottoStatistics(LottoBuyer lottoBuyer, List<Integer> winningNumbers, int bonusNumber) {
        LottoResults lottoResults = new LottoResults();
        List<Lotto> lottoList = lottoBuyer.getLottoTickets();

        for (Lotto lotto : lottoList) {
            List<Integer> lottoNumbers = lotto.getLotto();
            boolean isBonus = checkIsBonus(lottoNumbers, bonusNumber);
            int lottoCount = countLottoNumber(lottoNumbers, winningNumbers);
            getLottoCount(lottoResults, lottoCount, isBonus);
        }

        long totalWinnings = calculateTotalWinnings(lottoResults);

        printRankingResult(lottoResults);
        printProfitRate(totalWinnings, lottoBuyer.getPayment());
    }

    private void printProfitRate(long totalWinnings, int payment) {
        System.out.printf(PROFIT_RATE_MESSAGE, lottoProfitRate.getProfitRate(totalWinnings, payment));
    }


    private void getLottoCount(LottoResults lottoResults, int lottoCount, boolean isBonus) {
        if (lottoCount == 3) {
            lottoResults.add("FIFTH_PLACE", 1);
        } else if (lottoCount == 4) {
            lottoResults.add("FOURTH_PLACE", 1);
        } else if (lottoCount == 5 && !isBonus) {
            lottoResults.add("THIRD_PLACE", 1);
        } else if (lottoCount == 5 && isBonus) {
            lottoResults.add("SECOND_PLACE", 1);
        } else if (lottoCount == 6) {
            lottoResults.add("FIRST_PLACE", 1);
        }
    }

    private void printRankingResult(LottoResults lottoResults) {
        System.out.println("3개 일치 (5,000원) - " + lottoResults.getLottoPrizeCount("FIFTH_PLACE") + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResults.getLottoPrizeCount("FOURTH_PLACE") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResults.getLottoPrizeCount("THIRD_PLACE") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResults.getLottoPrizeCount("SECOND_PLACE") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResults.getLottoPrizeCount("FIRST_PLACE") + "개");
    }

    private long calculateTotalWinnings(LottoResults lottoResults) {
        return (5_000L * lottoResults.getLottoPrizeCount("FIFTH_PLACE")) +
                (50_000L * lottoResults.getLottoPrizeCount("FOURTH_PLACE")) +
                (1_500_000L * lottoResults.getLottoPrizeCount("THIRD_PLACE")) +
                (30_000_000L * lottoResults.getLottoPrizeCount("SECOND_PLACE")) +
                (2_000_000_000L * lottoResults.getLottoPrizeCount("FIRST_PLACE"));
    }

    private int countLottoNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int lottoCount = 0;
        for (int number : winningNumbers) {
            if (lottoNumbers.contains(number)) {
                lottoCount += 1;
            }
        }
        return lottoCount;
    }

    private boolean checkIsBonus(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}