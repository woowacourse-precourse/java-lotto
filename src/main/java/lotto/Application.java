package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        int lottoNum=userInputMoney();
        makeLotto(lottoNum);
    }

    private static void makeLotto(int lottoNum) {

    }

    //사용자 금액 입력
    private static int userInputMoney() {
        UserMoney userMoney = new UserMoney(Integer.parseInt(readLine()));
        return userMoney.getLottoNumber();
    }


}
