package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private int number;

    private final String answer;

    private final static int unitPrice = 1000;

    public Input() {
        number = 0;
        answer = "";
    }

    public int getNumber() {
        return this.number;
    }

    public String getAnswer() {
        return this.answer;
    }

    public int enterPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        return Integer.parseInt(price);
    }

    public boolean isNotMultiple(int price) {
        return (price % unitPrice != 0);
    }

    public void returnNumber(int price) {
        if(!isNotMultiple(price)) {
            number = price / unitPrice;
        }
        if(isNotMultiple(price)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 1000으로 나누어 떨어져야 합니다.");
        }
    }

}
