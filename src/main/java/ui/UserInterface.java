package ui;

import camp.nextstep.edu.missionutils.Console;
import config.ErrorConstants;

public class UserInterface {

    /**
     * 사용자로부터 구입금액을 입력받는다.
     * @return 구입금액
     * @throws IllegalArgumentException 구입금액이 숫자가 아니거나, 1000의 배수가 아닌 경우 예외 발생
     */
    public static int readPayment() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String line = Console.readLine();
        try {
            int payment = Integer.parseInt(line);
            if (payment < 1000 || payment % 1000 != 0) {
                throw new IllegalArgumentException(ErrorConstants.LESS_THAN_MINIMUM_UNIT);
            }
            return payment;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.NOT_NUMBER_INPUT);
        }
    }
}
