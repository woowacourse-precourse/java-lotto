package lotto;

import camp.nextstep.edu.missionutils.Console;
import
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구매금액을 입력해 주세요");
        String userInput = Console.readLine();

        Lotto.getNumbers();
    }
}
