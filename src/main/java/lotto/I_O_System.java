package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.IllformedLocaleException;
import java.util.List;

public class I_O_System {
    static final int lottey_price = 1000;
    public static final String BAGIC_ERROR_MESSAGE = "[ERROR]";
    private String Enter_Price;

    public void Enter_Price()
    {
        Enter_Price = Console.readLine();
       if(Differnet_Error()){
           int Number= Integer.parseInt(Enter_Price);
       }

    }

    private boolean Differnet_Error()
    {
        try {
            if(!(Enter_Price != null && Enter_Price.matches("[0-9.]+"))) {
                throw new IllegalArgumentException(BAGIC_ERROR_MESSAGE + " 오류 발생");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return false;

        }
        return true;
    }

    public boolean Check_True()
    {
        if(!Differnet_Error()) {
            return false;
        }

        return true;
    }


}
