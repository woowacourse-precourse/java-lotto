package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {

    public static void printView(String output) {
        OutputView.printEndsWithEnter(output);
    }

    public static void printView(List<String> outputs) {
        for (String output : outputs) {
            OutputView.printEndsWithEnter(output);
        }
    }

    public static String printViewWithUserInput(String output) {
        OutputView.printEndsWithEnter(output);
        return InputView.input();
    }

}
