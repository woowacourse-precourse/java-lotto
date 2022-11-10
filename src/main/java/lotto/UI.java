package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UI {
    private static int cost;

    public static int getCost() {
        return cost;
    }

    public static void setCost() {
        cost = Integer.parseInt(Console.readLine());
    }
}
