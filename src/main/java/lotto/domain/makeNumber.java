package lotto.domain;

import java.util.*;
import java.util.logging.Logger;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.logging.LoggerFactory;


public class makeNumber {

    private static final String ERROR_LOTTO_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_LOTTO_DUPLICATE = "[ERROR] 로또 당첨 번호는 중복이 있으면 안됩니다.";

    public makeNumber() {
    }

    public static String getAmountInput() {
        String money;
        System.out.println("구입 금액을 입력해주세요.");
        money = Console.readLine();
        return money;
    }

    public static String getWinningNumber() {
        String winningNumber;
        System.out.println("당첨 번호를 입력해주세요.");
        winningNumber = Console.readLine();
        return winningNumber;
    }

    public static String getBonusNumber() {
        String bonusNumber;
        System.out.println("보너스 번호를 입력해주세요.");
        bonusNumber = Console.readLine();
        checkRange(Integer.parseInt(bonusNumber));
        return bonusNumber;
    }

    public static Set<Integer> makeWinningNumber(String winningNumber, String bonusNumber) {
        Set<Integer> winner = new HashSet<>();
        addNumber(winningNumber, bonusNumber, winner);
        return winner;
    }

    public static void addNumber(String winningNumber, String bonusNumber, Set<Integer> winner) {
        for (String str : winningNumber.split(",")) {
            checkRange(Integer.parseInt(str));
            checkDuplicate(winner, Integer.parseInt(str));
            winner.add(Integer.parseInt(str));
        }
        checkDuplicate(winner, Integer.parseInt(bonusNumber));
        winner.add(Integer.parseInt(bonusNumber));
    }

    public static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_LOTTO_RANGE);
        }
    }

    public static void checkDuplicate(Set<Integer> winner, int number) {
        if (winner.contains(number)) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATE);
        }
    }

    public static int buyLotto(Money money) {
        int lotto = money.getAmountInput() / 1000;

        System.out.println(lotto + "개를 구매했습니다.");
        return lotto;
    }

    public static List<Integer> randomLotto() {
        List<Integer> number = new ArrayList<>();
        return number = Randoms.pickUniqueNumbersInRange(1, 45, 6);

    }


}
