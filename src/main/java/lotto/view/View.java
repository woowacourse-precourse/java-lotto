package lotto.view;

import camp.nextstep.edu.missionutils.Console;

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
}
