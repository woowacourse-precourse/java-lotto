package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public int receiveInput() {
        String input = Console.readLine();
        judgeIsDigitOfString(input);

        return Integer.parseInt(input);
    }

    public void judgeIsDigitOfString(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            char l = sentence.charAt(i);
            judgeIsDigitOfChar(l);
        }
    }

    public void judgeIsDigitOfChar(char word) {
        if (!Character.isDigit(word)) {
            throw new IllegalArgumentException("[ERROR] 입력은 자연수만 가능합니다.");
        }
    }
}
