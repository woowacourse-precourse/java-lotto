package lotto.view;

public class OutputView {
    private final String MESSAGE_TO_PRINT_COUNT = "개를 구매했습니다.";
    private final String MESSAGE_TO_PRINT_RESULT = "\n당첨 통계\n---";
    private final String MESSAGE_TO_PRINT_YIELD_A = "총 수익률은 ";
    private final String MESSAGE_TO_PRINT_YIELD_B = "%입니다.";

    public void printUserLottos(UserLottos userLottos) {
        printLottosCount(userLottos);
        printSortedLottos(userLottos);
    }
    public void printLottosCount(UserLottos userLottos) {
        int count = userLottos.getLottoCount();
        System.out.println("\n" + count + MESSAGE_TO_PRINT_COUNT);
    }
    public void printResult(LottoResult lottoResult) {
        System.out.println(MESSAGE_TO_PRINT_RESULT);
        System.out.println(lottoResult.getResultString());
        System.out.println(MESSAGE_TO_PRINT_YIELD_A + lottoResult.getYield() + MESSAGE_TO_PRINT_YIELD_B);
    }







}
