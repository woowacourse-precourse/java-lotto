package device.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleInput implements Input{

    @Override
    public List<Integer> enterIntegerList() {
        String inputMessage = Console.readLine();
        if (inputMessage == "") {
            return List.of();
        }

        return Arrays.stream(inputMessage.split(","))
                .map(string -> stringToInt(string))
                .collect(Collectors.toList());
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
            throw new IllegalArgumentException(InputErrorMessage.NOT_FORM_CORRECT.toString());
        }
    }
}
