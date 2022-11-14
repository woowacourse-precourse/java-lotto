package lotto.view;

import lotto.domain.model.Lottos;
import lotto.domain.model.WinningStatistics;
import lotto.domain.model.enums.Reward;
import lotto.view.utils.OutputUtils;

public class OutputView {

    private static final String ERROR_HEAD_MESSAGE = "[ERROR]";

    private OutputView() {
    }

    public static void printException(Exception exception) {
        OutputUtils.outputLine(ERROR_HEAD_MESSAGE + exception.getMessage());
        throw new IllegalArgumentException();
    }

    public static void printLottos(Lottos lottos) {
        int quantity = lottos.size();
        OutputUtils.outputLine(quantity + "개를 구매했습니다.");
        for (int index = 0; index < quantity; index++) {
            OutputUtils.outputLine(lottos.getLotto(index).toString());
        }
    }

    public static void printStatistics(WinningStatistics winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(Reward.FIFTH.getCorrectCount() + "개 일치 (" + Reward.FIFTH.getPrice() + "원) - "
                + winningStatistics.getCountOfReward(Reward.FIFTH) + "개");
        System.out.println(Reward.FOURTH.getCorrectCount() + "개 일치 (" + Reward.FOURTH.getPrice() + "원) - "
                + winningStatistics.getCountOfReward(Reward.FOURTH) + "개");
        System.out.println(Reward.THIRD.getCorrectCount() + "개 일치 (" + Reward.THIRD.getPrice() + "원) - "
                + winningStatistics.getCountOfReward(Reward.THIRD) + "개");
        System.out.println(Reward.SECOND.getCorrectCount() + "개 일치 보너스 볼 일치(" + Reward.SECOND.getPrice() + "원) - "
                + winningStatistics.getCountOfReward(Reward.SECOND) + "개");
        System.out.println(Reward.FIRST.getCorrectCount() + "개 일치 (" + Reward.FIRST.getPrice() + "원) - "
                + winningStatistics.getCountOfReward(Reward.FIRST) + "개");
    }
}
