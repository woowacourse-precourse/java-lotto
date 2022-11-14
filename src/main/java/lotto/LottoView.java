package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LottoView {

    public static void run() {
        int cost = buyAmount();
        if (cost == -1) {
            return;
        }
        int count = cost / 1000;
        List<Lotto> buyLottos = Lotto.buyMyLottos(count);

        Lotto lotto = winningNumber();
        if (lotto == null) {
            return;
        }
        int bonus = bonusNumber();
        if (bonus == -1) {
            return;
        }
        printResult(buyLottos, lotto, bonus, cost);
    }

    public static void printResult(List<Lotto> lottos, Lotto lotto, int bonus, int cost) {
        List<Integer> win = lotto.checkLottoAll(lottos, bonus);
        Lotto.printWin(win);
        Lotto.caculateProfit(win, cost);
    }



    public static int buyAmount() {
        System.out.println("구입금액을 입력해주세요.");
        try {
            String costInput = Console.readLine();
            validate(costInput);
            return Integer.parseInt(costInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static Lotto winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winning = new ArrayList<>();

        try {
            String[] winningInput = Console.readLine().split(",");
            for (String number : winningInput) {
                isNumber(number);
                winning.add(Integer.parseInt(number));
            }
            return new Lotto(winning);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            String bonusInput = Console.readLine();
            isNull(bonusInput);
            isNumber(bonusInput);
            return Integer.parseInt(bonusInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void validate(String input) {
        isNull(input);
        isNumber(input);
        isCorrect(input);
    }

    public static void isNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static void isNumber(String input) {
        if (!Pattern.matches("[0-9]+", input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    public static void isCorrect(String input) {
        int cost = Integer.parseInt(input);
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 입력이 가능합니다.");
        }
    }
}
