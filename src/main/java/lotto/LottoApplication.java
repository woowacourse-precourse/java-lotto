package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedList;

public class LottoApplication {
    private LinkedList<Lotto> lottoPool = new LinkedList<>();

    public void run() {
        LottoController lc = new LottoController();

        System.out.println("구입금액을 입력해 주세요.");
        int lottoAmount = lc.readUserMoney(Console.readLine()) / 1000;
        System.out.println("\n" + lottoAmount + "개를 구매했습니다.");
        for (int i = 0; i < lottoAmount; i++) {
            lottoPool.add(lc.createRandomLotto());
        }
        printLottoPool();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winNumber = Console.readLine();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println("\n당첨 통계\n---");
        printTotalPrize(new WinNumber(winNumber, bonusNumber), lottoAmount * 1000);
    }

    private void printTotalPrize(WinNumber wn, int paidMoney) {
        int[] result = new int[6];
        int totalEarn = 0;
        double earnRatio = 0;
        for (Lotto lotto : lottoPool) {
            Prize prize = lotto.compareWithAnswer(wn);
            totalEarn += prize.getPrize();
            result[prize.ordinal()]++;
        }
        System.out.println("3개 일치 (5,000원) - " + result[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[1] + "개");
        if (totalEarn != 0) {
            earnRatio = (totalEarn / (double) paidMoney) * 100;
        }
        System.out.printf("총 수익률은 " + "%.1f" + "%%입니다.", earnRatio);
    }

    private void printLottoPool() {
        for (Lotto lotto : lottoPool) {
            System.out.println(lotto.toString());
        }
    }
}
