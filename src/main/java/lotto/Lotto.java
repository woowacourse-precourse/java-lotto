package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 갯수 6개 예외
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개 여야 합니다.");
            throw new IllegalArgumentException();
        }
        // 1~45사이 숫자
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)<1 || numbers.get(i)>45){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
        // 중복 숫자 예외
        if(numbers.size() != numbers.stream().distinct().count()){
            System.out.println("[ERROR] 로또 번호는 중복이 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void printNumbers(){
        System.out.println(this.numbers);
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
