package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private boolean valduplicate(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            for(int j = 0; j < numbers.size(); j++){
                if(i == j) continue;
                if(numbers.get(i) == numbers.get(j)) return false;
            }
        }
        return true;
    }
    private boolean valrange(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++)
            if(numbers.get(i) < 0 || numbers.get(i) > 45) return false;
        return true;
    }
    private void validate(List<Integer> numbers) {
        //길이검사
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        //중복검사
        if(valduplicate(numbers) == false) throw new IllegalArgumentException();
        //범위검사
        if(valrange(numbers) == false) throw new IllegalArgumentException();
    }
    private int findidx(int n){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == n) return i;
        }
        return -1;
    }
    public LottoRank getRtn(List<Integer> truenum,int bonusnum){
        int cnt = 0;
        int bonus = 0;
        if(findidx(bonusnum) == 1) bonus = 1;
        for(int i = 0; i < truenum.size(); i++){
            if(truenum.get(i) != -1) cnt++;
        }
        if(cnt == 6) return LottoRank.First;
        if(cnt == 5 && bonus == 1) return LottoRank.Second;
        if(cnt == 5) return LottoRank.Third;
        if(cnt == 4 || (cnt == 3 && bonus == 1)) return LottoRank.Fourth;
        if(cnt == 3 || (cnt == 2 && bonus == 1)) return LottoRank.Fifth;
        return LottoRank.Sixth;
    }
    public void printInfo(){
        System.out.print("[");
        for(int i = 0 ; i < numbers.size(); i++){
            System.out.print(numbers.get(i));
            if(i != numbers.size()-1) System.out.print(",");
        }
        System.out.println("]");
    }

    // TODO: 추가 기능 구현
}
