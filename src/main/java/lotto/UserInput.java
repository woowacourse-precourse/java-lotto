package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class UserInput {

    static List<List<Integer>> lotteries = new ArrayList<>();
    private UserInput() {}

    static public long inputMoney() {
        String input = Console.readLine();
        validateMoney(input);
        return Long.parseLong(input);
    }

    static private void validateMoney(String input) {
        try {
            long money = Long.parseLong(input);
            if (money % 1000 != 0 || money == 0) {
                Message.ERROR_INPUT_1000.printError();
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            Message.ERROR_INPUT_NUMBER.printError();
            throw new IllegalArgumentException();
        }
    }

    static void generateRandomLotto(long quantity) {
        for (int i = 0; i < quantity; i++) {
            List tmpLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tmpLotto.sort(Comparator.naturalOrder());
            lotteries.add(tmpLotto);
        }
    }

    static void printLotto() {
        Iterator it = lotteries.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
