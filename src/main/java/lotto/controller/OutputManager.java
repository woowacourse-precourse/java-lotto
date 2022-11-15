package lotto.controller;

import java.text.DecimalFormat;

import lotto.model.lotto.Lotto;
import lotto.model.payment.Payment;
import lotto.model.statistics.LottoResult;
import lotto.model.statistics.LottoStatistics;
import lotto.view.ConsoleOutputView;

public class OutputManager {
    private final String PAYMENT_INPUT_ALERT = "구입금액을 입력해 주세요.";
    private final String WINNING_LOTTO_INPUT_ALERT = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_INPUT_ALERT = "보너스 번호를 입력해 주세요.";
    private final String STATISTICS_LABEL = "당첨 통계";
    private final String DIVIDER = "---";

    private static final DecimalFormat integerWithCommaFormatter = new DecimalFormat("###,###");
    private static final DecimalFormat floatWithCommaAndOneDecimalFormatter = new DecimalFormat("###,###.#");

    private final ConsoleOutputView outputView;

    public OutputManager() {
        this.outputView = new ConsoleOutputView();
    }

    public void printError(String errorText) {
        System.out.println("[ERROR] " + errorText);
    }

    public void printPaymentInputAlert() {
        outputView.println(PAYMENT_INPUT_ALERT);
    }

    public void printWinningLottoInputAlert() {
        outputView.println(WINNING_LOTTO_INPUT_ALERT);
    }

    public void printBonusNumberInputAlert() {
        outputView.println(BONUS_NUMBER_INPUT_ALERT);
    }

    public void printPaymentAlert(Payment payment) {
        outputView.println(payment.getLottoCount() + "개를 구매했습니다.");
    }

    public void printLotto(Lotto lotto) {
        outputView.println(lottoToString(lotto));
    }

    public void printLottoStatistics(Payment payment, LottoStatistics lottoStatistics) {
        outputView.println(STATISTICS_LABEL);
        outputView.println(DIVIDER);
        outputView.println(makeLottoHistoryDescription(lottoStatistics));
        outputView.println(makeReturnRateDescription(payment, lottoStatistics));
    }

    private String lottoToString(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i = 0; i < Lotto.LOTTO_NUMBER_LENGTH - 1; i++) {
            stringBuilder.append(lotto.getNumber(i).getNumber()).append(", ");
        }

        int lastIndex = Lotto.LOTTO_NUMBER_LENGTH - 1;
        if(lastIndex < 0) {
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        stringBuilder.append(lotto.getNumber(lastIndex).getNumber()).append("]");
        return stringBuilder.toString();
    }

    private String makeLottoHistoryDescription(LottoStatistics lottoStatistics) {
        StringBuilder stringBuilder = new StringBuilder();
        LottoResult[] sortedAllLottoResults = LottoResult.getValuesWithAscendingOrderByMatchCount();
        for (int i = 0; i < sortedAllLottoResults.length; i++) {
            LottoResult lottoResult = sortedAllLottoResults[i];
            if(lottoResult.equals(LottoResult.MISS)) {
                continue;
            }
            stringBuilder.append(makeLottoResultDescriptionWithCount(lottoStatistics, lottoResult));

            if(i != sortedAllLottoResults.length - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private String makeReturnRateDescription(Payment payment, LottoStatistics lottoStatistics) {
        int totalPayment = payment.getAmount();
        int totalPrize = lottoStatistics.getTotalPrize();
        float returnRate = 100 * ((float) totalPrize / (float) totalPayment);

        return "총 수익률은 " + floatWithCommaAndOneDecimalFormatter.format(returnRate) + "%입니다.";
    }

    private String makeLottoResultDescriptionWithCount(LottoStatistics lottoStatistics, LottoResult lottoResult) {
        int resultCount = lottoStatistics.getLottoResultCount(lottoResult);
        String resultDescription = makeLottoResultDescription(lottoResult);

        return resultDescription + " - " + resultCount + "개";
    }

    private String makeLottoResultDescription(LottoResult lottoResult) {
        if(lottoResult.equals(LottoResult.MISS)) {
            return "꽝";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoResult.getMatchCount()).append("개 일치");
        if(lottoResult.doesMatchBonusBall()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (");
        stringBuilder.append(integerWithCommaFormatter.format(lottoResult.getPrize()));
        stringBuilder.append("원)");

        return stringBuilder.toString();
    }
}
