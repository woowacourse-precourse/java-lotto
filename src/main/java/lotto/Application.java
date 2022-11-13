package lotto;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static Integer getLottoBuyCount() {
        Integer money;

        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        if (money % 1000 > 0)
            throw new IllegalArgumentException("1000으로 나누어지는 값을 입력해야 합니다.");

        return money / 1000;
    }
}
