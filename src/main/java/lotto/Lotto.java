package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개 이하 수 입력");
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
}
