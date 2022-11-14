package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {

    private static Integer purchaseAmount;
    private static List<Integer> winningNumbers = new ArrayList<>();
    private static Integer bonusNumber;

    private static List<Lotto> lottos = new ArrayList<>();

    private static Double ROI;

    private static void enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String temp = readLine();

        try {
            purchaseAmount = Integer.parseInt(temp);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 숫자로 이루어져야합니다.");
        }
    }

    private static void generateLottoNumbers() {
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
            lotto.printNumbers();
        }
    }

    private static void enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] temp = readLine().split(",");
        if(temp.length > 6) throw new IllegalArgumentException("[ERROR] 로또 번호가 6개를 초과했습니다.");
        for (String num : temp) {
            if(winningNumbers.contains(num)) throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            winningNumbers.add(Integer.valueOf(num));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.valueOf(readLine());
    }

    private static void determineWinningStatus() {
        for (Lotto lotto : lottos)
            lotto.setWinningStatus(winningNumbers, bonusNumber);
    }

    private static Double calculateROI(Double winningSum) {
        return Math.round(winningSum/purchaseAmount*1000.0)*0.1;
    }

    private static void printWinningStatistics() {
        Double winningSum = 0.0;
        System.out.println("당첨 통계\n---");
        WinningStatus[] winningStatuses = WinningStatus.values();
        for(WinningStatus winningStatus : winningStatuses) {
            if (winningStatus == WinningStatus.FAILED) continue;
            int matchCount = 0;
            for (Lotto lotto : lottos) if (lotto.getWinningStatus() == winningStatus) matchCount++;
            System.out.println(winningStatus.getDescription() + " - " + matchCount + "개");
            winningSum += winningStatus.getWinningAmount() * matchCount;
        }
        System.out.println("총 수익률은 " + calculateROI(winningSum) + "%입니다.");
    }

    public static void main(String[] args) {
        enterPurchaseAmount();
        if(purchaseAmount == null) return;
        generateLottoNumbers();
        enterWinningNumbers();
        determineWinningStatus();
        printWinningStatistics();
    }
}
