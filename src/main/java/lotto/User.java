package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    public int purchaseAmount() {

        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}