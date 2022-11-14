package device.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleInput implements Input{

    @Override
    public List<Integer> enterIntegerList() {
        String inputMessage = Console.readLine();
        return null;
    }

    @Override
    public Integer enterInteger() {
        String inputMessage = Console.readLine();
        if (inputMessage == "") {
            return null;
        }
        return stringToInt(inputMessage);
    }

    private int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
        }
    }
}
