package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.*;

public class Application {
    static String how_much_money() {
        Scanner scanner = new Scanner(System.in);

        String user_money;
        user_money = scanner.nextLine();

        return user_money;
    }

    public static void main(String[] args) {
        String user_money;
        user_money = how_much_money();
    }
}
