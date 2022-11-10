package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private final int issueCount;
    public Purchase() {
        int money = Integer.parseInt(Console.readLine());
        this.issueCount = money / 1000;
        System.out.println(issueCount);
    }

}
