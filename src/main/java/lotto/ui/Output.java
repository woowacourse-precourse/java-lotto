package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Rank;

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
        System.out.println(Rank.FIFTH_PLACE.getdetail() + gameResult.get(5) + "개");
        System.out.println(Rank.FOURTH_PLACE.getdetail() + gameResult.get(4) + "개");
        System.out.println(Rank.THIRD_PLACE.getdetail() + gameResult.get(3) + "개");
        System.out.println(Rank.SECOND_PLACE.getdetail() + gameResult.get(2) + "개");
        System.out.println(Rank.FIRST_PLACE.getdetail() + gameResult.get(1) + "개");
    }
}
