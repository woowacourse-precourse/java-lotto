package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static String ERROR_MESSAGE = "[ERROR]";
    public static int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 구입 금액 입력 받기
        int account = setAccount();


    }


    private static int setAccount() {
        int account = Integer.parseInt(Console.readLine());
        // 입력 받은 금액 검증
        if(validAccount(account)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.message());
        }
        return account;
    }

    private static boolean validAccount(int account) {
        if (account % 1000 == 0) {
            return false;
        }
        return true;
    }


}
