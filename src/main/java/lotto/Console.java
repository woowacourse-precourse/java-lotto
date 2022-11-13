package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Console {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.valueOf(readLine());
        return money;
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] strNumbers = readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < strNumbers.length; i++) {
            numbers.add(Integer.parseInt(strNumbers[i]));
        }
        return numbers;
    }
}
