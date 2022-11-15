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









}
