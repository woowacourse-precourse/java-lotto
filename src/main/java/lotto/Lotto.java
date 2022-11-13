package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDup(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개 이하 수 입력");
        }
    }
    private void validateDup(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++){
            int check = numbers.get(i);
            if(numbers.contains(check)&& numbers.indexOf(check)!=i){
                throw new IllegalArgumentException("[ERROR] 중복 입력 불가");
            }
        }
    }

    // TODO: 추가 기능 구현
    public void getLottoBonusNumber(String bonusNumber)throws IllegalArgumentException{
        validateBonusNumber(bonusNumber);
        this.numbers.add(Integer.parseInt(bonusNumber));
    }

    public void validateBonusNumber(String bonusNumber)throws IllegalArgumentException{
        for(int i=0; i<bonusNumber.length(); i++){
            if(bonusNumber.charAt(i)>=48 && bonusNumber.charAt(i)<=57){
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값 숫자로만 입력");
        }
    }

    public List<Integer> printLottoNumber(){
        return numbers;
    }
}
