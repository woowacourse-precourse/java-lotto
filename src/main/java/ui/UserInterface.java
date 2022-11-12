package ui;

import camp.nextstep.edu.missionutils.Console;
import config.ErrorConstants;
import config.PrintConstants;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    /**
     * 사용자로부터 구입금액을 입력받는다.
     * @return 구입금액
     * @throws IllegalArgumentException 구입금액이 숫자가 아니거나, 1000의 배수가 아닌 경우 예외 발생
     */
    public static int readPayment() throws IllegalArgumentException {
        System.out.println(PrintConstants.INPUT_PAYMENT);
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

    /**
     * 사용자로부터 당첨 번호를 입력받는다.
     * 각 번호는 ','로 구분되며 6개의 정수를 입력하여야 한다.
     * @return 당첨번호
     * @throws IllegalArgumentException 숫자가 아니거나, 로또번호로 생성될 수 없는 경우 예외 발생
     */
    public static Lotto readLuckyNumbers() throws IllegalArgumentException {
        System.out.println(PrintConstants.INPUT_LUCKY_NUMBERS);
        String[] tokens = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorConstants.NOT_NUMBER_INPUT);
            }
        }

        return new Lotto(numbers);
    }

    /**
     * 보너스 번호를 입력 받습니다.
     * @return 보너스 번호
     * @throws IllegalArgumentException 숫자가 아닌 경우 예외 발생
     */
    public static int readBonusNumber() throws IllegalArgumentException {
        System.out.println(PrintConstants.INPUT_BONUS_NUMBER);
        String line = Console.readLine();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.NOT_NUMBER_INPUT);
        }
    }
}
