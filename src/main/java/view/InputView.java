package view;

import camp.nextstep.edu.missionutils.Console;
import utils.IllegalInputFormChecker;
import utils.InputMessage;

public class InputView{
    IllegalInputFormChecker illegalInputFormChecker = new IllegalInputFormChecker();
    static String userPayment;
    static int newUserPayment;
    static String userInput;
    static String userBonus;


    public int getUserPayMessage() {
        System.out.println(InputMessage.USER_PAY);
        userPayment = Console.readLine();
        illegalInputFormChecker.checkUserPayIllegal(userPayment);
        newUserPayment = Integer.parseInt(userPayment);
        return newUserPayment;
    }

    public String getUserNumsMessage() {
        System.out.println(InputMessage.USER_NUMS);
        userInput = Console.readLine();
        illegalInputFormChecker.checkUserInputIllegal(userInput);
        return userInput;
    }

    public String getUserBonusNumMessage() {
        System.out.println(InputMessage.USER_BONUS_NUM);
        userBonus = Console.readLine();
        illegalInputFormChecker.checkUserBonusIllegal(userBonus);
        return userBonus;
    }
}
