package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    public static void getUserMoneyInput() {
        GameOutput.printMoneyInput();
        String userInput = Console.readLine();
        //예외처리
        //값 저장 추가 예정
    }

    public static void getUserNumberInput() {
        GameOutput.printNumberInput();
        String userInput = Console.readLine();
        //예외처리
        //값 저장 추가 예정
    }

    public static void getUserBonusNumberInput() {
        GameOutput.printBonusNumberInput();
        String userInput = Console.readLine();
        //예외처리
        //값 저장 추가 예정
    }
}
