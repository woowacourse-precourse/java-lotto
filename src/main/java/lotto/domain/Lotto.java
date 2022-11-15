package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static List<Integer> allNumbers;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        allNumbers = numbers;
        this.numbers = numbers;
        show(numbers);
    }

    public static List<Lotto> createLotto(int number){
        List<Lotto> allLotto = new ArrayList<>();
        for(int i = 0; i < number; i++){
            allLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return allLotto;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void show(List<Integer> numbers){
        System.out.println(numbers);
    }

    public static int calculate(String input){
        int money = Integer.valueOf(input);
        if(money % 1000 == 0){
            return money / 1000;
        }
        throw new IllegalArgumentException("구입 금액은 1000원 단위만 가능합니다.");
    }

    public static void checkIsInt(String input){
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("구입 금액 입력은 숫자만 가능합니다.");
            }
        }
    }
}
