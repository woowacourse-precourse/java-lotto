package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    // 로또 크기 검증
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> numSet = new HashSet<>(numbers);

        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException();
        }


    }





    public static List<Integer> pick() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;


    }

    public static int compare(List<Integer> pick, ArrayList<Integer> answers){

        int answer = 0;

        for(int i=0; i<pick.size(); i++){
            if(answers.contains(pick.get(i))){
                answer+=1;
            }
        }


        return answer;
    }
}
