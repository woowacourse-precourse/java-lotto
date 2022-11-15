package util.input.global;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputUtil {
    public static String getInput() {
        return Console.readLine().trim();
    }

    public static List<String> getInputs() {
        String[] inputs = Console.readLine().trim().split(",");

        return List.of(inputs);
    }
}
