package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class LottoController {

    public void readUserMoney(String userMoney) {
        isDigit(userMoney);
        validateUserMoney(userMoney);
    }

    public Lotto readWinNumber(String userWinNumber) {
        StringTokenizer st = new StringTokenizer(userWinNumber, ",");
        ArrayList<Integer> winNumber = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String singleNumber = st.nextToken();
            isDigit(singleNumber);
            validateWinNumber(singleNumber);
            winNumber.add(Integer.parseInt(singleNumber));
        }

        Collections.sort(winNumber);
        return new Lotto(winNumber);
    }

    private void isDigit(String userInput) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, userInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다");
        }
    }

    private void validateWinNumber(String userInput) {
        int incomingNumber = Integer.parseInt(userInput);
        if (incomingNumber < 1 || incomingNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이여야 합니다");
        }
    }

    private void validateUserMoney(String userInput) {
        int money = Integer.parseInt(userInput);

        if (money == 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 이상의 금액을 입력해야 합니다");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 단위의 금액을 입력해야 합니다");
        }
    }
}
