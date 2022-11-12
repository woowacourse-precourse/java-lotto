package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public final static String ILLEGAL_INPUT_ERROR = "[ERROR] 잘못된 입력입니다.";
    public final static String ILLEGAL_UNIT_ERROR = "[ERROR] 금액의 단위는 1,000원입니다.";
    public final static String ILLEGAL_LENGTH_ERROR = "[ERROR] 당첨 번호는 6자리입니다.";
    public final static String ILLEGAL_RANGE_ERROR = "[ERROR] 번호의 범위는 1~45까지 입니다.";
    public final static String ILLEGAL_DUPLICATE_ERROR = "[ERROR] 중복되지 않는 번호여야 합니다.";
    public final static int MONEY_UNIT = 1_000;
    public final static int START_RANGE = 1;
    public final static int END_RANGE = 45;

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyString = Console.readLine();
        System.out.println();

        moneyString = moneyString.replaceAll(",", "");
        int money = safeStringToInt(moneyString);
        validateMoney(money);

        return money;
    }

    private static int safeStringToInt(String number) {
        int result;

        try {
            result = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ILLEGAL_DUPLICATE_ERROR);
        }

        return result;
    }

    private static void validateMoney(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ILLEGAL_UNIT_ERROR);
        }
    }
}
