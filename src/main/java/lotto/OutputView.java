package lotto;

import java.util.List;

public class OutputView {
    public static void printUserLotto(List<Lotto> userLotto) {
        printAmount(userLotto.size());
        userLotto.stream()
                .forEach(System.out::println);
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }
}
