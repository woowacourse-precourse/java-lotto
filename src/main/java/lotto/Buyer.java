package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Buyer {
    public int money;

    public void getMoney() {
        this.money = Integer.parseInt(readLine());
    }
}
