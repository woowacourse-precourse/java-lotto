package lotto;


import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void getPriceToBuy() {
        System.out.println("구입 금액을 입력해주세요.");
        String response = Console.readLine();
        stringToInt(response);
    }

    public static int stringToInt(String response) {
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 정수로 입력해야 합니다.");
        }
    }


}
