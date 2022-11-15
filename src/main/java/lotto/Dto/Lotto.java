package lotto.Dto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkedNumber(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers){
        vaildate(numbers);
        List<Integer> winningNumbers = new ArrayList<>();
        String[] winningNum = numbers.split(",");
        for(String number : winningNum){
            if(winningNumbers.contains(number)){
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 들어왔습니다.");
            }
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
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[ERROR] 형식에 맞추어 입력하세요.");
        String regularExpression = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}";
        if(!numbers.matches(regularExpression)){
            throw illegalArgumentException;
        }
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int num){
        return this.numbers.contains(num);
    }

    public void checkedNumber(List<Integer> winningNum){
        for(int number : winningNum){
            if(winningNum.contains(number)){
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 들어왔습니다.");
            }
        }
    }
}
