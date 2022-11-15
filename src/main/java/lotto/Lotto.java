package lotto;


import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;




public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Lotto_number(numbers);
        InRange(numbers);
        validate(numbers);
        delete_overlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void Lotto_number(List numbers) {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    private void delete_overlap(List<Integer> numbers){
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호 중복");
        }
    }
    private void InRange(List<Integer> numbers){
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i)>46 || numbers.get(i)<1){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이에 위치해야합니다.");
            }
        }
    }
}
