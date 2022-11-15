package lotto;

import java.nio.channels.IllegalChannelGroupException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        System.out.println(numbers);
        this.numbers = numbers;
        }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 ) {
            throw new IllegalArgumentException();
        }
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() < numbers.size()){
            throw new IllegalArgumentException();
        }
    }
    public static void lottoNumber(List<Integer> lotto){
        System.out.println("당첨번호를 입력해주세요.");
        String lottoNumber = Console.readLine();
        String[] listSplit = lottoNumber.split(",");
        for(int i=0 ; i<listSplit.length ; i++ ){
            lotto.add(Integer.parseInt(listSplit[i]));
            error(lotto.get(i));
        }
    }

    public static int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        int bonus = Integer.parseInt(bonusNumber);
        error(bonus);
        return bonus;
    }

    public static int compareNumber(List<Integer> numbers, List<Integer> lottoNumber, int bonus){
        List<Integer> compareNumber = new ArrayList<>(numbers);
        compareNumber.retainAll(lottoNumber);
        if (compareNumber.size() == 5){
            if (numbers.contains(bonus)){
                return -1;
            }
        }
        return compareNumber.size();
    }

    private static void error(int num){
        if(num < 1 || num >45){
            throw new IllegalArgumentException("[ERROR] 숫자 범위는 1~45까지 입니다.");
        }
    }
    // TODO: 추가 기능 구현
}
