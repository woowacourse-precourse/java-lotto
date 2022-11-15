package lotto.controller;

import java.text.DecimalFormat;

import lotto.model.payment.Payment;
import lotto.model.statistics.LottoResult;
import lotto.model.statistics.LottoStatistics;

public class IoManager {
    private final String PUT_PAYMENT_INPUT_ALERT = "구입금액을 입력해 주세요.";
    private final String PUT_WINNING_NUMBERS_INPUT_ALERT = "당첨 번호를 입력해 주세요.";
    private final String PUT_BONUS_NUMBER_INPUT_ALERT = "보너스 번호를 입력해 주세요.";
    private final String STATISTICS_LABEL = "당첨 통계";
    private final String DIVIDER = "---";

    private static final DecimalFormat integerWithCommaFormatter = new DecimalFormat("###,###");
    private static final DecimalFormat floatWithCommaAndOneDecimalFormatter = new DecimalFormat("###,###.#");

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
        for (LottoResult lottoResult: LottoResult.values()) {
            if(lottoResult.equals(LottoResult.MISS)) {
                continue;
            }

            String resultDescription = makeLottoResultDescription(lottoResult);
            int resultCount = lottoStatistics.getLottoResultCount(lottoResult);

            stringBuilder.append(resultDescription)
                    .append(" - ")
                    .append(resultCount)
                    .append("개");
            if(lottoResult.ordinal() != LottoResult.FIRST.ordinal()) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public String makeReturnRateDescription(Payment payment, LottoStatistics lottoStatistics) {
        int totalPayment = payment.getAmount();
        int totalPrize = lottoStatistics.getTotalPrize();
        float returnRate = 100 * ((float) totalPrize / (float) totalPayment);

        return "총 수익률은 " + floatWithCommaAndOneDecimalFormatter.format(returnRate) + "%입니다.";
    }
}
