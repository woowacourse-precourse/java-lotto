package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        int pay = inputPay();
        int lottoCount = pay/1_000;
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers);
            lottoNumbers.add(numbers);
        }

        // TODO: 프로그램 구현
    }

    public static int inputPay() {
        System.out.println("구입금액을 입력해 주세요.");
        return checkPay(Console.readLine());
    }

    public static int checkPay(String str) {
        int pay;
        try {
            pay = Integer.parseInt(str);

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자만 입력하실 수 있습니다.");
            throw new IllegalArgumentException();
        }
        if (pay % 1_000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }
        return pay;
    }
}
