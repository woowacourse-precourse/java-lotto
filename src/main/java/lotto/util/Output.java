package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class Output {

    /**
     * 로또 구입 금액 입력 문구 출력하는 함수
     */
    public static void printAmountInputText() {
        System.out.println("\n구입금액을 입력해 주세요.");
    }

    /**
     * 로또의 개수와 각 로또의 번호들을 출력하는 함수
     */
    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(System.out::println);
    }

    /**
     * 당첨 번호 입력 문구를 출력하는 함수
     */
    public static void printInputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    /**
     * 보너스 번호 입력 문구를 출력하는 함수
     */
    public static void printInputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
}
