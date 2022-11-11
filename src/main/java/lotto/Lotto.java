package lotto;

package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45 , 6);
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 구입 금액 입력
    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(Console.readLine());

        return inputMoney;
    }

    // 로또 구입 갯수
    public int theNumberOfLotto(){
        int howManyLotto = inputMoney() / 1000;

        return howManyLotto;
    }















    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6자리의 숫자여야 합니다.");
        }
        for (int i =0; i < numbers.size(); i++){
            if (numbers.get(i) <= 0 || numbers.get(i) > 45){
                throw new IllegalArgumentException("[ERRO] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
}