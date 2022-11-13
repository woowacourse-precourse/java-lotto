package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Draw {
    private final List<List<Integer>> publishedLottos = new ArrayList<>();
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;
    private final int PICK_COUNT = 6;

    public void start() {
        System.out.println("구입금액을 입력해 주세요.");
        int payAmount = 0;
        try {
            payAmount = Integer.parseInt(Console.readLine());
            if(payAmount % 1_000 != 0) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
                throw new IllegalArgumentException();
            }
            publish(payAmount / 1_000);
            Lotto lotto = new Lotto(pickWinnerNumbers());
            lotto.getResult(payAmount, pickBonusNumber(), publishedLottos);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위의 숫자로 이뤄져야 합니다.");
        }
    }

    public void startForTest(String payAmountForTest) {
        System.out.println("구입금액을 입력해 주세요.");
        int payAmount = 0;
        try {
            payAmount = Integer.parseInt(payAmountForTest);
            if(payAmount % 1_000 != 0) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
                throw new IllegalArgumentException();
            }
            publish(payAmount / 1_000);
            Lotto lotto = new Lotto(pickWinnerNumbers());
            lotto.getResult(payAmount, pickBonusNumber(), publishedLottos);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위의 숫자로 이뤄져야 합니다.");
            throw new IllegalArgumentException();

        }
    }

    private void publish(int amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
        for(int i=0; i<amount; i++) {
            List<Integer> issued = new ArrayList<>();
            issued.addAll(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_COUNT));
            Collections.sort(issued);
            publishedLottos.add(issued);
            System.out.println(issued.toString());
        }
    }
    
    private List<Integer> pickWinnerNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Arrays.asList(Console.readLine().split(","))
                    .stream()
                    .map(number -> Integer.parseInt((String) number))
                    .collect(Collectors.toList());
    }

    private Integer pickBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = 0;
        try {
            bonus = Integer.parseInt(Console.readLine());
            if(bonus < 1 || bonus > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 번호는 숫자로 이뤄져야 합니다.");
            throw new IllegalArgumentException();
        }
        return bonus;
    }

    public Integer pickBonusNumberForTest(String bonusForTest) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = 0;
        try {
            bonus = Integer.parseInt(bonusForTest);
            if(bonus < 1 || bonus > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 번호는 숫자로 이뤄져야 합니다.");
            throw new IllegalArgumentException();
        }
        return bonus;
    }
}
