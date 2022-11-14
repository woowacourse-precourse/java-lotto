package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        checkDuplicate(numbers);
        List<Integer> orderNum = orderLotto(numbers);
        this.numbers = orderNum;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> list){
        Set<Integer> numSet = new HashSet<>(list);
        //중복이 있음
        if(numSet.size()!=list.size()){
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현

    private List<Integer> orderLotto(List<Integer> numbers){
        List<Integer> orderNum = new ArrayList<>();
        for(Integer integer : numbers){
            orderNum.add(integer);
        }
        Collections.sort(orderNum);
        return orderNum;
    }

    public List<Integer> getLotto(){
        return numbers;
    }

    public String toStringLotto(){
        String str="[";
        for(int i=0; i<numbers.size()-1; i++){
            str+=numbers.get(i);
            str+=", ";
        }
        str+=(numbers.get(numbers.size()-1)+"]");
        return str;
    }
}
