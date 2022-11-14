package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static int validatePayment() {
        String payment = readLine();
        if (Integer.parseInt(payment) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(payment) / 1000;
    }

    public static void main(String[] args) {
        int payment = validatePayment();
    }
}
