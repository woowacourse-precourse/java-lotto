package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputServiceImpl implements InputService{
    static int userPayment = 0;
    static String userInput;
    static String userBonus;

    @Override
    public int getUserPayMessage() {
        System.out.println(InputMessage.USER_PAY);
        userPayment = Integer.parseInt(Console.readLine());
        return userPayment;
    }

    @Override
    public String getUserNumsMessage() {
        System.out.println(InputMessage.USER_NUMS);
        userInput = Console.readLine();
        return userInput;
    }

    @Override
    public String getUserBonusNumMessage() {
        System.out.println(InputMessage.USER_BONUS_NUM);
        userBonus = Console.readLine();
        return userBonus;
    }
}
