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

    // 사용자의 당첨 번호 & 보너스 번호 입력
    public static List inputWinNumber() {
        List<Integer> winNumber = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputNumber = Console.readLine().split(",");
        for(int i = 0; i < inputNumber.length; i++) {
            if(winNumber.contains(Integer.parseInt(inputNumber[i]))) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 당첨 번호입니다.");
            }
            winNumber.add(Integer.parseInt(inputNumber[i]));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if(winNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 보너스 번호입니다.");
        }
        winNumber.add(bonusNumber);

        return winNumber;
    }

    // 당첨 개수 카운트
    public static void countStat (int sameNumber) {

        if(sameNumber == 3) {
            SAME_STAT[0]++;
        } else if (sameNumber == 4) {
            SAME_STAT[1]++;
        } else if (sameNumber == 5) {
            SAME_STAT[2]++;
        } else if (sameNumber == -1) {
            SAME_STAT[3]++;
        } else if (sameNumber == 6) {
            SAME_STAT[4]++;
        }

    }
    }
}
