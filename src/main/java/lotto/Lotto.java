package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<List<Integer>> buyLotto(int purchaseMoney){
        return digitPick(purchaseMoney/1000);
    }
    public int inputMoney(){
        int purchaseMoney = Integer.parseInt(Console.readLine());
        if (purchaseMoney%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력하십시오.");
        }
        return purchaseMoney;
    }

    private List<List<Integer>> digitPick(int purchaseAmount){
        List<List<Integer>> lottoNums = new ArrayList<>();
        while (lottoNums.size()!=purchaseAmount){
            lottoNums.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottoNums;
    }


}
