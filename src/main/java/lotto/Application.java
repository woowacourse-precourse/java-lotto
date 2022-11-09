package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        inputPay();

        // TODO: 프로그램 구현
    }

    public static int inputPay() {
        System.out.println("구입금액을 입력해 주세요.");
        return checkPay(readLine());
    }

    public static int checkPay(String str) {
        int pay;
        try {
            pay = Integer.parseInt(str);

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자만 입력하실 수 있습니다.");
            throw new IllegalArgumentException();
        }
        if (pay % 1_000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }
        return pay;
    }
}
