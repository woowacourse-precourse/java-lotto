package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int checkWin() {
        LottoWin lottoWin = LottoWin.getInstance();
        List<Integer> winNumber = lottoWin.getLottoNum();
        int sameCnt = 0;
        for(int user : this.numbers){
            if(winNumber.contains(user)){
                sameCnt += 1;
            }
        }
        return sameCnt;
    }

    // TODO: 추가 기능 구현
}
