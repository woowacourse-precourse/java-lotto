package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 ) {
            throw new IllegalArgumentException();
        }
    }
    public static void lottoNumber(List<Integer> lotto){
        System.out.println("당첨번호를 입력해주세요.");
        String lottoNumber = Console.readLine();
        String[] listSplit = lottoNumber.split(",");
        for(int i=0 ; i<listSplit.length ; i++ ){
            lotto.add(Integer.parseInt(listSplit[i]));
            if (lotto.get(i) < 1  || lotto.get(i) >45 ){
                throw new IllegalArgumentException("[ERROR] 숫자 범위는 1~45까지 입니다.");
            }
        }
    }

    public static int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        int bonus = Integer.parseInt(bonusNumber);
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위는 1~45까지 입니다.");
        }
        return bonus;
    }
    // TODO: 추가 기능 구현
}
