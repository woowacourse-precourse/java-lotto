package lotto.domain;

import java.util.List;

public class Print {

    /**
     * 로또 구입 금액 입력 문구 출력하는 함수
     */
    public static void printInputPurchaseAmount() {
        System.out.println("\n구입금액을 입력해 주세요.");
    }

    /**
     * 로또의 개수와 각 로또의 번호들을 출력하는 함수
     */
    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(System.out::println);
    }
}
