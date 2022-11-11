package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class I_O_System {
    static final int lottey_price = 1000;
    public static final String BAGIC_ERROR_MESSAGE = "[ERROR]";

    public void Enter_Price()
    {
        String Enter_Price = Console.readLine();
        Differnet_Error(Enter_Price);
    }

    private void Differnet_Error(String Number) {
        try {
            if(!(Number != null && Number.matches("[0-9.]+"))) {
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE + " 오류 발생");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());

        }

    }

}
