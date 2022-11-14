package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String lotto = getLotto();
        if (lotto.equals("ERROR")) {
            return;
        }
        Integer price = Integer.valueOf(lotto);
    }

    public static String getLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        try {
            Integer.valueOf(price);
        } catch (Exception e) {
            System.out.println("[ERROR] 숫자 변환이 불가능한 경우");
            return "ERROR";
//            throw new IllegalArgumentException("[ERROR] 숫자 변환이 불가능한 경우");
        }
        if (Integer.valueOf(price)%1000 != 0) {
            System.out.println("[ERROR] 1000으로 나누어 떨어지지 않는 경우");
            return "ERROR";
//            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지지 않는 경우");
        }
        return price;
    }
}
