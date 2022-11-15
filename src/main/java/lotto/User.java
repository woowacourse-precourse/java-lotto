package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    public static final int DIVIDE = 1000;
    private int cash = 0;
    private int boughtNum = 0;
    private Validation validation = new Validation();


    public User() {

    }

    public void buyLotto() {
        System.out.println("구입금앨을 입력해 주세요.");
        this.cash = Integer.valueOf(Console.readLine());
        if (!validation.cashDivideValidate(cash, DIVIDE)) {
            throw new IllegalArgumentException();
        }
        this.boughtNum = cash / DIVIDE;
    }
}
