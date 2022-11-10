package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int inputMoney() {
        String inputMoney = Console.readLine();
        validateMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static void validateMoney(String inputMoney) {
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }
}
