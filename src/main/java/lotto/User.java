package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private int userMoney;
    private int resultMoney;

    public void readMoney(){
        int inputMoney = Integer.parseInt(readLine());
        validateInputNumber(inputMoney);
        userMoney = inputMoney;
    }
}
