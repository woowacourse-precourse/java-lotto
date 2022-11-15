package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int EACH_LOTTO_COST = 1000;

    int lottoCost = 0;

    public int getLottoCost() {
        return lottoCost;
    }

    public void receiveCostInput() {
        String input = Console.readLine();
        judgeIsDigitOfString(input);

        lottoCost = Integer.parseInt(input);
        judgeCostValidate(lottoCost);
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

    public void judgeCostValidate(int cost) {
        if (cost % EACH_LOTTO_COST != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
