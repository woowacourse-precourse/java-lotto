package ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class InputView {
    Message message = new Message();

    public int inputPrice() {
        message.INPUT_PRCIE_MESSAGE();
        return new Scanner(Console.readLine()).nextInt();
    }

}
