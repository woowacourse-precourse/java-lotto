package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR]";

    public static String[] PLACE = {"3개 일치 (5,000원) - ",
                                    "4개 일치 (50,000원) - ",
                                    "5개 일치 (1,500,000원) - ",
                                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                                    "6개 일치 (2,000,000,000원) - "};

    public static int[] SAME_STAT = new int[5];
    public static int QUANTITY = 0;

    public static final int[] PAY = {5000, 50000, 1500000, 30000000, 2000000000};

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    // 사용자의 구매 금액 입력 (에러 판별)
    public static int input(int inputMoney) {

//        for(int i = 0; i < inputMoneyStr.length(); i++) {
//            if(!(inputMoneyStr.charAt(i) >= '0' && inputMoneyStr.charAt(i) <= '9')) {
//                throw new IllegalArgumentException("[ERROR]");
//            }
//        }

        //int inputMoney = Integer.parseInt(inputMoneyStr);

        if(inputMoney % 1000 != 0) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return inputMoney;
    }
    }
}
