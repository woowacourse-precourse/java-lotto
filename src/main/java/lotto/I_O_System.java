package lotto;

import camp.nextstep.edu.missionutils.Console;

public class I_O_System {
    static final int lottey_price = 1000;
    public static final String BAGIC_ERROR_MESSAGE = "[ERROR]";
    private static final String Sell_Messge = "개를 구매했습니다.";
    private static final String ERROR_Code_1 = " 숫자가 아닌 문자가 들어왔습니다.";
    private static final String ERROR_Code_2 = " 돈이 천원 단위로 나누어지지않습니다.";
    private String Enter_Number = "0";
    private int Money_Enter = 0;

    public void Enter_Price() {
        Enter_Number = Console.readLine();
        Int_Changer();
        left_money();
        Money_Enter /= lottey_price;
        System.out.println(Money_Enter + Sell_Messge);

    }

    private int Int_Changer() {
        if (Differnet_Error()) {
            Money_Enter = Integer.parseInt(Enter_Number);
        }
        return Money_Enter;
    }

    private boolean Differnet_Error() {
        try {
            if (!(Enter_Number != null && Enter_Number.matches("^[0-9]*$"))) {
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE + ERROR_Code_1);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return false;

        }
        return true;
    }

    private boolean left_money() {
        int Base_Number = 0;
        try {
            if ((Base_Number = Money_Enter % 1000) > 0) {
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE + ERROR_Code_2);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

    public boolean Check_True() {
        if (!Differnet_Error()) {
            return false;
        }
        if (!left_money()) {
            return false;
        }

        return true;
    }
public void Enter_Number()
{
    Enter_Number =Console.readLine();
}


}
