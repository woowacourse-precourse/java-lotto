package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class I_O_System {
    static final int lottey_price = 1000;

    private void Enter_Price()
    {
        String Enter_Price = Console.readLine();

    }

    private void Differnet_Error(String Number)
    {
        try{
            int number = Integer.parseInt(Number);
        }
        catch (IllegalAccessError ex)
        {
            ex.printStackTrace();
        }
    }
}
