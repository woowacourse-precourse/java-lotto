package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    public void printIssuedLotto(List<Lotto> issuedLotto) {
        System.out.println(issuedLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : issuedLotto) {
            lotto.printNumbers();
        }
    }

    public void printGameResult(List<Integer> gameResult) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + gameResult.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + gameResult.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + gameResult.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + gameResult.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + gameResult.get(1) + "개");
    }
}
