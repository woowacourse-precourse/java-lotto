package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
    //1. 로또 구매시 랜덤 번호를 담는 함수
    public List<Integer> buyLottoRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    //2. 당첨에 대한 금액을 산정하는 함수
    //3. 입력 받은 금액이 1000원단위인지 확인하는 함수
    public void moneyUnitCheck(int inputMoney){
        if(inputMoney % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }
    //4. 당첨 번호와 보너스 번호를 입력받는 함수
    //5. 발행한 로또 번호를 정렬 하는 함수 (오름차순)
    //6. 당첨 내역을 출력하는 함수
    //7. 수익률을 계산하는 함수 (소수 두째자리에서 반올림)
    //8. 예외처리 에러 문구 출력 함수 (단, [ERROR] 로 시작)
}
