package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

    private String userInput;
    private int userMoney;
    public int lottoCount;

    public UserInterface() {
        System.out.println("구입금액을 입력해 주세요.");

        this.userInput = Console.readLine();
        validateNotNull(userInput);

        this.userMoney = validateNumber(userInput);
        validateNoChange(userMoney);

        this.lottoCount = userMoney / 1000;
    }


    private void validateNotNull(String userInput) {
        if (userInput == null || "0".equals(userInput)) {
            throw new IllegalArgumentException("구입금액은 0이상의 값을 입력하세요.");
        }
    }

    private int validateNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
        }
    }

    private void validateNoChange(int userMoney) {
        if (userMoney % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
        }
    }

}
