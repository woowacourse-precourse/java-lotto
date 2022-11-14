package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoPrinter {
    public static String inputer(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
        System.out.println();
        return inputValue;
    }

    public static void lottosPrint(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
