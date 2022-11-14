package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto{

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요");
        }
        Set<Integer> hashNumber = new HashSet<>(numbers);
        if (hashNumber.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력했습니다");
        }
    }
    public static ArrayList<List<Integer>> randomNumberGenerate(int numberOfGame){
        int i = 0;
        ArrayList<List<Integer>> userNumber = new ArrayList<>();
        do{
            Lotto numbers = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(numbers.numbers);
            ArrayList<Integer> sortNumbers= new ArrayList<>();
            for(int k=0;numbers.numbers.size()>k;k++){sortNumbers.add(numbers.numbers.get(k));}
            Collections.sort(sortNumbers);
            userNumber.add(sortNumbers);
            i ++;
        }while (i != numberOfGame);
        return userNumber;
    }
}
