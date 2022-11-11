package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.*;

public class Application {
    static void ask_how_much_money() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static String how_much_money() {
        Scanner scanner = new Scanner(System.in);

        String user_money;
        user_money = scanner.nextLine();

        return user_money;
    }

    static void check_user_money(String user_money) {
        int test_user_money;

        try {
            test_user_money = Integer.parseInt(user_money);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if ((test_user_money <= 0) || ((test_user_money % 1000) != 0)) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        ask_how_much_money();

        String user_money;
        user_money = how_much_money();

        try {
            check_user_money(user_money);
        } catch (IllegalArgumentException e) {
        }
    }
}
