package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Integer amount;
        try {
            amount = Integer.valueOf(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("구매 금액은 숫자여야 합니다.");
        }
        Lotto.checkBuyAmount(amount);
        amount = amount/1000;
        List<List<Integer>> lottos = Lotto.generateLotto(amount);

    }
}
