package Views;

import Utils.Exceptions;

public class InputView {
    public static final InputView INPUT_VIEW = new InputView();

    public int InputCash(String readLine) {
        Exceptions.ExcludeUnderThousand(readLine);
        return Integer.parseInt(readLine) / 1000;
    }
}
