package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String inputPayment(){
        OutputView.printPriceInputMessage();
        return readLine();
    }
}
