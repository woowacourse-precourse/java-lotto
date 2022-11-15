package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoCreate lottoCreate = new LottoCreate(numbers);
        this.numbers = lottoCreate.getLottoNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }




    // TODO: 추가 기능 구현

    public Lotto (LottoCreate lottoCreate){
        this.numbers = lottoCreate.getLottoNumbers();
    }

    public void print(){
        System.out.println(numbers);
    }

    public boolean containNumber(int x){
        return this.numbers.contains(x);
    }

}
