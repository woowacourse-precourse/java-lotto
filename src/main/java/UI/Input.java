package UI;

import Exception.PriceException;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int price() {
        Output.inputPrice();
        String price = Console.readLine();
        PriceException.checkException(price);
        return Integer.valueOf(price);
    }
}
