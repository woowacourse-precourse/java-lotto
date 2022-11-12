package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.IllformedLocaleException;
import java.util.List;

public class I_O_System {
    static final int lottey_price = 1000;
    public static final String BAGIC_ERROR_MESSAGE = "[ERROR]";
    private static final String Sell_Messge = "개를 구매했습니다.";
    private String Enter_Price = "0";
    private int Number = 0;

    public void Enter_Price() {
        Enter_Price = Console.readLine();
        Int_Changer();
        left_money();
        Number /= lottey_price;
        System.out.println(Number + Sell_Messge);

    }

    private int Int_Changer() {
        if (Differnet_Error()) {
            Number = Integer.parseInt(Enter_Price);
        }
        return Number;
    }

    private boolean Differnet_Error() {
        try {
            if (!(Enter_Price != null && Enter_Price.matches("^[0-9]*$"))) {
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE);
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
            if ((Base_Number = Number % 1000) > 0) {
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE+ "Error2");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.println(Base_Number);
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


}
