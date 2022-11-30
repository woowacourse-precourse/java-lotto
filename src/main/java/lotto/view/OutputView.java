package lotto.view;

import lotto.dto.output.PrintLottoDto;
import lotto.dto.output.PrintLottoResultDto;

public class OutputView {

    private final String LINE_FEED = "";

    private OutputView() {
    }

    private static class OutputViewSingletonHelper {
        private static final OutputView OUTPUT_VIEW = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputView.OutputViewSingletonHelper.OUTPUT_VIEW;
    }

    public void printLotto(PrintLottoDto printLottoDto) {
        print(LINE_FEED);
        print(OutputViewMessage.PURCHASE_AMOUNT.getFullMessage(printLottoDto.getPurchaseAmount()));
        printLottoDto.getPurchaseLottos().forEach(purchaseLotto ->
                print(OutputViewMessage.LOTTO.getFullMessage(purchaseLotto)));
    }

    public void printLottoResult(PrintLottoResultDto printLottoResultDto) {
        print(LINE_FEED);
        printLottoResultDto.getLottoRankingLog().forEach(this::print);
    }

    private void print(String message) {
        System.out.println(message);
    }

    private enum OutputViewMessage {
        PURCHASE_AMOUNT("%d개를 구매했습니다."),
        LOTTO("[%s]"),
        GUIDE_RESULT("당첨 통계"),
        GUIDE_CONTOUR("---"),
        EXCEPTION("[ERROR] %s");

        private final String baseMessage;

        OutputViewMessage(String baseMessage) {
            this.baseMessage = baseMessage;
        }

        public String getFullMessage(Object... replaces) {
            return String.format(this.baseMessage, replaces);
        }
    }
}
