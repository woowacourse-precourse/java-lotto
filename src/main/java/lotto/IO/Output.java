package lotto.IO;

import lotto.data.Rank;
import lotto.domain.Lotto;
import lotto.domain.StartLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Result.calculate;
import static lotto.domain.Result.getCount;


public class Output {

    public static void printLotto() {
        System.out.println(Lotto.lottoQuantity + "개를 구매했습니다.");
        for (Lotto e : StartLotto.lotto)
            printNumbers(e);
    }

    public static void printNumbers(Lotto lotto) {
        List<Integer> numberForPrint = new ArrayList<>();
        for (int e : lotto.getNums())
            numberForPrint.add(e);
        Collections.sort(numberForPrint);
        System.out.println(numberForPrint);
    }

    public static void requestWinNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank e : Rank.values())
            printRank(e);
        System.out.println("총 수익률은 " + calculate() + "%입니다.");
    }

    public static void printRank(Rank e) {
        System.out.println(e.getCondition() + " (" + e.getPrize() + ") - " + getCount(e.getRank()) + "개");
    }
}
