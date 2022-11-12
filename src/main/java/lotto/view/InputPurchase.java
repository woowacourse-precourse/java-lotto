package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.UserDTO;

public class InputPurchase {
    private static final String PURCHASE_REQUEST = "구입금액을 입력해 주세요.";

    private String inputData;
    public InputPurchase() {
        System.out.println(PURCHASE_REQUEST);
    }

    public UserDTO makeUserData() {
        int amount;

        getInput();
        amount = inputPurchase(this.inputData);
        UserDTO userDTO = new UserDTO(amount);
        return userDTO;
    }

    private void getInput() {
        String inputData;

        inputData = Console.readLine();
        this.inputData = inputData;
    }

    private int inputPurchase(String inputData) {
        UserDTO userDTO;
        int amount = 0;

        amount = checkPurchase(inputData);
        return amount;
    }

    private int checkPurchase(String inputData) {
        int amount;

        checkNumeric(inputData);
        amount = Integer.parseInt(inputData);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 입력할 수 있습니다.");
        }
        return amount;
    }

    private void checkNumeric(String amount) {
        for (int i = 0; i < amount.length(); i++) {
            checkIsNum(amount.charAt(i));
        }
    }
    private void checkIsNum(char ch) {
        if ('0' > ch || '9' < ch) {
            throw new IllegalArgumentException("[ERROR] 숫자값을 입력해야 합니다.");
        }
    }

}
