package lotto;


import camp.nextstep.edu.missionutils.Console;

public class Cash {
    public void Input() {
        int money = 0;
        String inputCash = Console.readLine();
        if(isNumeric(inputCash)) {
            money = Integer.parseInt(inputCash);
            validiate(money);
        }

        System.out.println(money);
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
