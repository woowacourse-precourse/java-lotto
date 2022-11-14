package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.object.WinningHistory;
import lotto.object.Yield;

import java.util.List;

public class View {

    public static String getInput() {
        return Console.readLine();
    }

    public static void printDepositView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoAmount(Integer amount) {
        System.out.println(String.format("%d개를 구매했습니다.", amount));
    }

    public static void printLottoNumbers(List<List<Integer>> lottos) {
        lottos.stream().forEach(System.out::println);
    }

    public static void printWinningHistory(WinningHistory history) {
        System.out.println(history);
    }

    public static void printYield(Yield yield) {
        System.out.println(String.format("총 수익률은 %s입니다.", yield.toString()));
    }
}
