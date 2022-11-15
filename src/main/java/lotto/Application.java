package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Lotto> lottos = new ArrayList<>();
        int numberOfLotto = getTheNumberOfLotto();

        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        printLottos(lottos);

    }

    public static int getTheNumberOfLotto() {
        String money = Console.readLine();
        validate(money);
        int numberOfLotto = Integer.parseInt(money) / 1000;

        return numberOfLotto;
    }

    public static void validate(String money) {
        if (validateMoneyType(money) || validateMoneyRange(money)) {
            System.out.println("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateMoneyType(String money) {
        // 오류가 있으면 true
        for (char c : money.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    public static boolean validateMoneyRange(String money) {
        // 오류가 있으면 true
        if(Integer.parseInt(money) % 1000 != 0) {
            return true;
        }

        return false;
    }

    public static List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            lotto.printLotto();
        }
    }

}
