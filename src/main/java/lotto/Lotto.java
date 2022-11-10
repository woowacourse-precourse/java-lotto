package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 한장의 로또 티켓 정보를 관리하는 클래스
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if(!validateConsistOfSixNumber(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.");
        }

        if(!validateEachNumberInRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호의 각 숫자는 1~45 사이의 값을 가져야 합니다.");
        }

        if(!validateEachNumberIsDistinct(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자들은 중복되어서는 안됩니다.");
        }
    }

    private Boolean validateEachNumberInRange(List<Integer> numbers){
        return null;
    }

    private Boolean validateConsistOfSixNumber(List<Integer> numbers){
        return null;
    }

    private Boolean validateEachNumberIsDistinct(List<Integer> numbers){
        return null;
    }
    // TODO: 추가 기능 구현

    public Integer getCountOfMatchNumber(Lotto otherLotto){
        return null;
    }

    public Boolean hasNumber(Integer number){
        return null;
    }

    public String toString(){
        return null;
    }
}
