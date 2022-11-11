package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            int lottoCount = getLottoCount(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public static int getLottoCount(String string) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 숫자 형식 또는 정수가 아닙니다.");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 양수가 아닙니다.");
        }
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 1,000원으로 나누어떨어지지 않습니다.");
        }
        return number / 1000;
    }

    public static List<Integer> getRandomUniqueNumberList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
