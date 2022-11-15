package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinningStatistics;
import lotto.domain.model.enums.Reward;
import lotto.view.utils.OutputUtils;

public class OutputView {

    private static final String ERROR_HEAD_MESSAGE = "[ERROR] ";
    private static final String DECIMAL_FORMAT = "#,###";

    private OutputView() {
    }

    public static void printException(Exception exception) {
        OutputUtils.output(ERROR_HEAD_MESSAGE + exception.getMessage());
        //throw new IllegalArgumentException(ERROR_HEAD_MESSAGE + exception.getMessage());
    }

    public static void printLottos(Lottos lottos) {
        int quantity = lottos.size();
        OutputUtils.outputLine(quantity + "개를 구매했습니다.");
        for (int index = 0; index < quantity; index++) {
            OutputUtils.outputLine(lottos.getLotto(index).toString());
        }
    }

    public static void printStatistics(WinningStatistics winningStatistics) {
        OutputUtils.outputLine("당첨 통계");
        OutputUtils.outputLine("---------");
        OutputUtils.outputLine(
                Reward.FIFTH.getCorrectCount() + "개 일치 (" + toNumFormat(Reward.FIFTH.getPrice()) + "원) - "
                        + winningStatistics.getCountOfReward(Reward.FIFTH) + "개");
        OutputUtils.outputLine(
                Reward.FOURTH.getCorrectCount() + "개 일치 (" + toNumFormat(Reward.FOURTH.getPrice()) + "원) - "
                        + winningStatistics.getCountOfReward(Reward.FOURTH) + "개");
        OutputUtils.outputLine(
                Reward.THIRD.getCorrectCount() + "개 일치 (" + toNumFormat(Reward.THIRD.getPrice()) + "원) - "
                        + winningStatistics.getCountOfReward(Reward.THIRD) + "개");
        OutputUtils.outputLine(
                Reward.SECOND.getCorrectCount() + "개 일치, 보너스 볼 일치 (" + toNumFormat(Reward.SECOND.getPrice()) + "원) - "
                        + winningStatistics.getCountOfReward(Reward.SECOND) + "개");
        OutputUtils.outputLine(
                Reward.FIRST.getCorrectCount() + "개 일치 (" + toNumFormat(Reward.FIRST.getPrice()) + "원) - "
                        + winningStatistics.getCountOfReward(Reward.FIRST) + "개");
    }

    private static String toNumFormat(Long num) {
        DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);
        return df.format(num);
    }

    public static void printRateOfReturn(Double rateOfReturn) {
        OutputUtils.outputLine("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
