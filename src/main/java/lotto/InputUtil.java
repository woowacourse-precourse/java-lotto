package  lotto;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtil {
    public String inputNumber() {
        String inputNumbers = readLine();
        return inputNumbers;
    }
    public String[] splitNumber() {
        String numbers = inputNumber();
        String[] arrayNumbers = numbers.split(",");
        return arrayNumbers;
    }
}