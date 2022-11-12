package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        int lottoNum=userInputMoney();
    }

    private static int userInputMoney() {
        String userMoney= readLine();
        int lottoNum=Integer.parseInt(userMoney)/1000;
        return lottoNum;
    }
}
