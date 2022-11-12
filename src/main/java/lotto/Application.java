package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        int lottoNum=userInputMoney();
    }
    //사용자 금액 입력
    private static int userInputMoney() {
        int userMoney= Integer.parseInt(readLine());
        checkErrorInUserInputMoney(userMoney);
        int lottoNum=userMoney/1000;
        return lottoNum;
    }
    //사용자 금액 입력 예외처리
    private static void checkErrorInUserInputMoney(int userMoney) {
        if(userMoney%1000!=0){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

}
