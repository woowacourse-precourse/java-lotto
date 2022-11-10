package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Console {
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
    public void outputMyLottos(List<Integer>[] numbers) {
        int count = numbers.length;
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }
    }
}
