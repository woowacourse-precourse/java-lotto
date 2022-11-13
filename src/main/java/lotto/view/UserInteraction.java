package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInteraction {
    public UserInteraction() {
    }

    public String money() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public void showLotto(int count, List<List<Integer>> numbers) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        for(int i = 0; i < count; i++) {
            System.out.println(numbers.get(i));
        }
    }
}
