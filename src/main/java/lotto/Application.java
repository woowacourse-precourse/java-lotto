package lotto;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int getPriceToBuy() {
        System.out.println("구입 금액을 입력해주세요.");
        String response = Console.readLine();
        return Integer.parseInt(response);
    }
}
