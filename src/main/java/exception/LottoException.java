package exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoException extends IllegalStateException {
    LottoException(String message){
        super(message);
    }

    public void validateNumbers(List<Integer> numbers){
        if( numbers.size() != 6 ) throw new LottoException("[ERROR] 숫자의 개수를 6개민 유효합니다.");
        for(Integer number : numbers){
            if(number < 1 || number > 45) throw new LottoException("[ERROR] 로또 숫자의 범위는 1에서 45사이만 유효합니다.");
            if(number == null) throw new LottoException("[ERROR] 로또 숫자는 널이 될 수 없습니다.");
            if(numbers.indexOf(number) != numbers.lastIndexOf(number)){
                throw new LottoException("[ERROR] 로또 숫자는 중복될 수 없습니다.");
            }
        }
    }

    public void IllegalMoneyException(int money){
        if( money % 1000 != 0 ) throw new LottoException("[ERROR] 사용자 투자 금액은 1000으로 나누어떨어져야 유효합니다.");
    }


}
