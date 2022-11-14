package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void buyLotto(int purchaseMoney){
        int purchaseAmount = purchaseMoney/1000;
        //purchaseAmount를 인자로 받아서 list를 반환하는 로또 뽑기 기능 추가

    }
    private int inputMoney(){
        int purchaseMoney = Integer.parseInt(Console.readLine());
        if (purchaseMoney%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력하십시오.");
        }
        return purchaseMoney;
    }
}
