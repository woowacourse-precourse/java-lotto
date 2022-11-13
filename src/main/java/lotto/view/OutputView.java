package lotto.view;

import lotto.domain.model.Lottos;
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
}
