package lotto.view;

import static lotto.domain.model.enums.Reward.FIFTH;
import static lotto.domain.model.enums.Reward.FIRST;
import static lotto.domain.model.enums.Reward.FOURTH;
import static lotto.domain.model.enums.Reward.SECOND;
import static lotto.domain.model.enums.Reward.THIRD;

import java.text.DecimalFormat;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinningStatistics;
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
        OutputUtils.outputLine(FIFTH.getCorrectCount() + "개 일치 (" + toNumFormat(FIFTH.getPrice()) + "원) - "
                + winningStatistics.getCountOfReward(FIFTH) + "개");
        OutputUtils.outputLine(FOURTH.getCorrectCount() + "개 일치 (" + toNumFormat(FOURTH.getPrice()) + "원) - "
                + winningStatistics.getCountOfReward(FOURTH) + "개");
        OutputUtils.outputLine(THIRD.getCorrectCount() + "개 일치 (" + toNumFormat(THIRD.getPrice()) + "원) - "
                + winningStatistics.getCountOfReward(THIRD) + "개");
        OutputUtils.outputLine(SECOND.getCorrectCount() + "개 일치, 보너스 볼 일치 (" + toNumFormat(SECOND.getPrice()) + "원) - "
                + winningStatistics.getCountOfReward(SECOND) + "개");
        OutputUtils.outputLine(FIRST.getCorrectCount() + "개 일치 (" + toNumFormat(FIRST.getPrice()) + "원) - "
                + winningStatistics.getCountOfReward(FIRST) + "개");
    }

    private static String toNumFormat(Long num) {
        DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);
        return df.format(num);
    }

    public static void printRateOfReturn(Double rateOfReturn) {
        OutputUtils.outputLine("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
