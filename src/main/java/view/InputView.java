package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요." + System.lineSeparator();
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요." + System.lineSeparator();
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요." + System.lineSeparator();
    private static final String INPUT_MONEY_TYPE_ERROR_MESSAGE = "[ERROR] 입력은 숫자여야만 합니다."

    public static int inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String money = Console.readLine();
        
        // 입력이 숫자인지만 확인
        isDigit(money);

        return Integer.parseInt(money);
    }

    public static String inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    private static void isDigit(String money){
        for(int i=0; i<money.length(); i++){
            if(!Character.isDigit(money.charAt(i))){
                throw new IllegalArgumentException(INPUT_MONEY_TYPE_ERROR_MESSAGE);
            }
        }
    }
}
