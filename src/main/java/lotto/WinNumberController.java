package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class WinNumberController {

    public List<Integer> readWinNumber(String userWinNumber) {
        StringTokenizer st = new StringTokenizer(userWinNumber, ",");
        ArrayList<Integer> winNumber = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String singleNumber = st.nextToken();
            isDigit(singleNumber);
            winNumber.add(Integer.parseInt(singleNumber));
        }

        Collections.sort(winNumber);
        return winNumber;
    }


    public Integer readBonusNumber(String userBonusNumber) {
        isDigit(userBonusNumber);

        return Integer.parseInt(userBonusNumber);
    }

    private void isDigit(String userInput) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, userInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다");
        }
    }
}
