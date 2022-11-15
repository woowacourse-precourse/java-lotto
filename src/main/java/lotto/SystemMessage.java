package lotto;

import java.util.List;

public class SystemMessage {
    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }
        System.out.println();
    }

    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult(List<Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(4) + "개");
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}