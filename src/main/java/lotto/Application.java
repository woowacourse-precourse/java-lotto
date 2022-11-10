package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private List<Integer> winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> lottonumbers = Arrays.asList(Console.readLine().split(","))
                .stream()
                .map((s -> Integer.parseInt(s.trim())))
                .collect(Collectors.toList());

        return lottonumbers;
    }

    private int purchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount <= 0) {
            throw new IllegalArgumentException("0보다 같거나 작은 수는 허용되지 않습니다.");
        } else if (amount%1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000 배수여야 합니다.");
        }

        return amount/1000;
    }

    private List<List<Integer>> makeUserLottoNumbers(int numOfLotto) {
        System.out.printf("%d개를 구매했습니다.\n",numOfLotto);
        List<List<Integer>> userLottoNumbers = new ArrayList<>();
        for (int n=0; n<numOfLotto; n++) {
            List<Integer> userNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(userNumber);
            System.out.println(userNumber);
            userLottoNumbers.add(userNumber);
        }
        return userLottoNumbers;
    }

    public static void main(String[] args) {
        Application app =  new Application();
        try {
            int amount = app.purchaseAmount();
            List<List<Integer>> userLottoNumbers = app.makeUserLottoNumbers(amount);
            Lotto lotto = new Lotto(app.winningNumber());
            int bonus = lotto.bonus();
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s\n", e.getMessage());
        }
    }
}
