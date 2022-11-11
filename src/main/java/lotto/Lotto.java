package lotto;

import java.util.Collections;
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

    // TODO: 추가 기능 구현

    // sorting numbers
    public void sortNumbers(){
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return "[" + numbers +"]";
    }

    // match checking
    public LottoPrice matchResult(List<Integer> list, int wildCard, int[] result){
        // Exception 처리
        // 1. 서로 크기가 다른 경우
        LottoPrice res;
        int _cnt = 0;
        for(int here : numbers){
            for(int there : list){
                if(here == there) _cnt++;
            }
        }
        res = LottoPrice.valueOfMatchCounts(_cnt);
        if(_cnt == 5 && numbers.contains(wildCard)) res = LottoPrice.SECOND;
        result[res.ordinal()]++;
        return res;
    }

    // for bonus card checking
    public boolean matchBonusNum(int num){
        return numbers.contains(num);
    }
}
