package UserInterface;

import java.util.List;

public class OutputValues {
    public void showLottoPaymentReceipt(int totalPayment, List<List<Integer>> generatedLotto) {
        String receipt = "";

        receipt += String.format("%d개를 구매했습니다.\n", totalPayment);

        for (List<Integer> lotto : generatedLotto) {
            receipt = receipt.concat(lotto.toString() + '\n');
        }
        System.out.println(receipt);
    }

    public void showTotalWinningResult(List<Integer> result, String yield) {
        String report = "당첨 통계\n---\n";
        report += String.format("3개 일치 (5,000원) - %d개\n", result.get(0));
        report += String.format("4개 일치 (50,000원) - %d개\n", result.get(1));
        report += String.format("5개 일치 (1,500,000원) - %d개\n", result.get(2));
        report += String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(4));
        report += String.format("6개 일치 (2,000,000,000원) - %d개\n", result.get(3));
        report += "총 수익률은 " + yield + "%입니다.";
        System.out.println(report);
    }
}
