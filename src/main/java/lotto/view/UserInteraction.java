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
        String[] numbers = numberValid(input);
        return numberTransform(numbers);
    }

    private String[] numberValid(String input) {
        String[] inputs = input.split(",");
        if(inputs.length != 6){
            throw new IllegalArgumentException();
        }
        return inputs;
    }

    private List<Integer> numberTransform(String[] numbers) {
        List<Integer> winNumbers = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            winNumbers.add(Integer.parseInt(numbers[i]));
        }
        return winNumbers;
    }
}
