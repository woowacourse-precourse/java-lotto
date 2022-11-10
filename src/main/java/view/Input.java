package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String price;
    private final String answer;
    public Input() {
        price = "";
        answer = "";
    }
    public String getPrice() {
        return this.price;
    }
    public String getAnswer() {
        return this.answer;
    }
    public String enterPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

}
