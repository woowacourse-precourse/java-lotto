package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto{

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        System.out.println("여기가디스"+this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public static ArrayList<List<Integer>> randomNumberGenerate(int numberOfGame){
        int i = 0;
        ArrayList<List<Integer>> userNumber = new ArrayList<>();
        do{
            Lotto numbers = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(numbers.numbers);
            ArrayList<Integer> sortNumbers= new ArrayList<>();
            for(int k=0;numbers.numbers.size()>k;k++){
                sortNumbers.add(numbers.numbers.get(k));
            }
            Collections.sort(sortNumbers);
            userNumber.add(sortNumbers);
            i ++;
        }while (i != numberOfGame);
        return userNumber;
    }
}
