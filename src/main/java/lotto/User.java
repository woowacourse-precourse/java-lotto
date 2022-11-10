package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

public class User {

    public int purchaseAmount() {

        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}