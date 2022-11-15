package View;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    static final String INPUT_BUYING_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void printBuyingLottoMessage(){
        printMessage(INPUT_BUYING_LOTTO_MESSAGE);
    }

    public static void printInputWinningNumberMessage(){
        printMessage(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public static void printInputBonusNumberMessage(){
        printMessage(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static String readInputLine(){
        String returnString = readLine();
        return returnString;
    }

}
