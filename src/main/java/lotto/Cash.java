package lotto;


import camp.nextstep.edu.missionutils.Console;

public class Cash {
    int cnt = 0;
    int money = 0;

    public void Input(String inputCash) {
        if(isNumeric(inputCash)) {
            money = Integer.parseInt(inputCash);
            validiate(money);
        }
        cnt = money / 1000;
    }

    private void validiate(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
