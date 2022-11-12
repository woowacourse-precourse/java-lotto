package lotto.playlotto.object;

import lotto.input_output.Input;

import java.util.List;

public class Lotto extends Input {
    private final List<Integer> numbers;    //로또를 시작할 때 사용자에게 입력받는 값

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    // TODO: 추가 기능 구현
    /*
    - 당첨 번호 입력 받아 numbers에 저장
    - 자기 로또 번호 반환
     */
    public List<Integer> returnNumbers(){
        return this.numbers;
    }

    public static void main(String[] args) {
        Lotto lotto = new Lotto(Lotto.returnList());
        System.out.println(lotto.numbers);
        System.out.println("numbers 사이즈: "+ lotto.numbers.size());
    }


}
