package lotto.view;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_TYPE_ERROR_MESSAGE = "[ERROR] 입력타입이 잘못되었습니다.\n";
    public static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String WINNING_NUMBER_DELIMITER  = ",";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputBonusNumber() {
        try {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            int bonusNumber = Integer.parseInt(Console.readLine());
            System.out.println();
            return bonusNumber;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE);
        }
    }

    public static List<Integer> inputWinningNumber() {
        try {
            System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
            String winningNumber[] = Console.readLine().split(WINNING_NUMBER_DELIMITER);
            List<Integer> lottoList = new ArrayList<>();
            for (int i = 0; i < winningNumber.length; i++) {
                lottoList.add(Integer.parseInt(winningNumber[i]));
            }
            System.out.println();
            return lottoList;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE);
        }
    }

    public static int inputMoney() {
        try {
            System.out.println(INPUT_PRICE_MESSAGE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE);
        }
    }

}


