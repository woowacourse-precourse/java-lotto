package lotto;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static String Input() {
        return Console.readLine();
    }

    public static void Output(String message) {
        System.out.println(message);
    }

}
