package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInteraction {
    public UserInteraction() {
    }

    public String money() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void showLotto(int count, List<List<Integer>> numbers) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        for(int i = 0; i < count; i++) {
            System.out.println(numbers.get(i));
        }
    }

    public List<Integer> winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return numberTransform(input);
    }

    private List<Integer> numberTransform(String input) {
        String[] numbers = input.split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            winNumbers.add(Integer.parseInt(numbers[i]));
        }
        return winNumbers;
    }

    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return bonusTransform(input);
    }

    private int bonusTransform(String input) {
        return Integer.parseInt(input);
    }
}
