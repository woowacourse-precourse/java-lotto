package lotto;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    public enum INPUT_SENTENCE {
        WIN("당첨 번호를 입력해 주세요.\n"), BONUS("보너스 번호를 입력해 주세요.\n");

        private final String label;

        INPUT_SENTENCE(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = numbers();
        validateCount(numbers);
        validateOverlap(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private List<Integer> numbers() {
        System.out.print(Lotto.INPUT_SENTENCE.WIN.label());
        String number = Console.readLine();
        List<String> winNumbers = new ArrayList<>(Arrays.asList(number.split("\\s*,\\s*")));
        List<Integer> winNumber = new ArrayList<>();
        for(int i = 0; i<winNumbers.size(); i++) {
            winNumber.add(Integer.parseInt(winNumbers.get(i)));
        }
        return winNumber;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++){
            if (Collections.frequency(numbers,numbers.get(i)) != 1) {
                throw new IllegalArgumentException("[ERROR] 숫자가 중복되지 않아야 합니다.");
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++) {
            if(numbers.get(i)< 1 || numbers.get(i)> 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}