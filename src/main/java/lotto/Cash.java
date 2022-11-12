package lotto;


import camp.nextstep.edu.missionutils.Console;

public class Cash {
    int cnt = 0;

    public void Input(String inputCash) {
        int money = 0;
        // String inputCash = Console.readLine();
        if(isNumeric(inputCash)) {
            money = Integer.parseInt(inputCash);
            validiate(money);
        }
        cnt = money / 1000;
    }

    private void validiate(int money) {
        if(money % 1000 != 0) {
            System.out.println("[ERROR] 잘못된 값을 입력하셨습니다");
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 잘못된 값을 입력하셨습니다");
            throw new IllegalArgumentException();
        }
    }
}
