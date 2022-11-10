package lotto;

import camp.nextstep.edu.missionutils.Console;

public class DataInput {
    public static String UserInput(String Message) {
        System.out.println(Message);
        String input = Console.readLine();

        return input;
    }
}
