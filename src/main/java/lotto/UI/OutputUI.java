package lotto.UI;

import lotto.Lotto;

import java.util.List;

public class OutputUI {

    public OutputUI() {
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottos(List<Lotto> lottos) {
        // TODO: Lotto 번호를 형식에 맞게 출력해야함.
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public void printWinnerCounts(List<Integer> winnerCounts, double returnRate) {
        printWinnerResult(winnerCounts);
        printReturnReate(returnRate);
    }

    private void printWinnerResult(List<Integer> winnerCounts) {
        //TODO: ENUM으로 Refactoring 예정
        System.out.println("3개 일치 (5,000원) - 1개");
        System.out.println("4개 일치 (50,000원) - 0개\n");
        System.out.println("5개 일치 (1,500,000원) - 0개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        System.out.println("6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 62.5%입니다.");
    }

    private void printReturnReate(double returnRate) {
        System.out.println("총 수익률은 " + returnRate +"%입니다.");
    }
}
