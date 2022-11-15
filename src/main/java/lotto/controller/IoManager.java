package lotto.controller;

import java.text.DecimalFormat;

import lotto.model.payment.Payment;
import lotto.model.statistics.LottoResult;
import lotto.model.statistics.LottoStatistics;

public class IoManager {
    public final String PUT_PAYMENT_INPUT_ALERT = "구입금액을 입력해 주세요.";
    public final String PUT_WINNING_NUMBERS_INPUT_ALERT = "당첨 번호를 입력해 주세요.";
    public final String PUT_BONUS_NUMBER_INPUT_ALERT = "보너스 번호를 입력해 주세요.";
    public final String STATISTICS_LABEL = "당첨 통계";
    public final String DIVIDER = "---";

    private static final DecimalFormat integerWithCommaFormatter = new DecimalFormat("###,###");
    private static final DecimalFormat floatWithCommaAndOneDecimalFormatter = new DecimalFormat("###,###.#");


    public String makePaymentAlert(Payment payment) {
        return payment.getLottoCount() + "개를 구매했습니다.";
    }

    public String makeLottoResultDescription(LottoResult lottoResult) {
        if(lottoResult.equals(LottoResult.MISS)) {
            return "꽝";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoResult.getMatchCount()).append("개 일치");
        if(lottoResult.doesMatchBonusBall()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (").append(integerWithCommaFormatter.format(lottoResult.getPrize())).append("원)");

        return stringBuilder.toString();
    }

    public String makeLottoHistoryDescription(LottoStatistics lottoStatistics) {
        StringBuilder stringBuilder = new StringBuilder();

        LottoResult[] sortedAllLottoResults = LottoResult.getValuesWithAscendingOrderByMatchCount();
        for (int i = 0; i < sortedAllLottoResults.length; i++) {
            LottoResult lottoResult = sortedAllLottoResults[i];
            if(lottoResult.equals(LottoResult.MISS)) {
                continue;
            }

            int resultCount = lottoStatistics.getLottoResultCount(lottoResult);
            String resultDescriptionWithCount = makeLottoResultDescriptionWithCount(lottoResult, resultCount);
            stringBuilder.append(resultDescriptionWithCount);

            if(i != sortedAllLottoResults.length - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private String makeLottoResultDescriptionWithCount(LottoResult lottoResult, int count) {
        String resultDescription = makeLottoResultDescription(lottoResult);
        return resultDescription + " - " + count + "개";
    }

    public String makeReturnRateDescription(Payment payment, LottoStatistics lottoStatistics) {
        int totalPayment = payment.getAmount();
        int totalPrize = lottoStatistics.getTotalPrize();
        float returnRate = 100 * ((float) totalPrize / (float) totalPayment);

        return "총 수익률은 " + floatWithCommaAndOneDecimalFormatter.format(returnRate) + "%입니다.";
    }
}
