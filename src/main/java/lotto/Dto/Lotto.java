package lotto.Dto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers){
        vaildate(numbers);
        List<Integer> winningNumbers = new ArrayList<>();
        String[] winningNum = numbers.split(",\\s");
        for(String number : winningNum){
            winningNumbers.add(Integer.parseInt(number));
        }
        this.numbers = winningNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 길이가 6이 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void vaildate(String numbers){
        String regularExpression = "^\\d{1,2},\\s\\d{1,2},\\s\\d{1,2},\\s\\d{1,2},\\s\\d{1,2},\\s\\d{1,2}";
        if(!numbers.matches(regularExpression)){
            throw new IllegalArgumentException("[ERROR] 형식에 맞추어 입력하세요.");
        }
    }

    public String toString(){
        return numbers.toString();
    }
}
