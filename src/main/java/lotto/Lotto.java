package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public static int bonusNumber;
    private static HashSet checkDuplicate = new HashSet();

    public Lotto(List<Integer> numbers) {
        Validations.checkLength(numbers);
        Validations.checkDuplication(numbers);

        // 로또 번호를 부여하기 전 정렬.
        ArrayList sortedNumbers = new ArrayList(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public void setBonusNumber(){
        String temp = Console.readLine();

        Validations.checkBonusNumberIsNumeric(temp);
        bonusNumber = Integer.parseInt(temp);

        Validations.checkBonusNumberDuplicate(bonusNumber, numbers);
        Validations.checkNumberRange(bonusNumber);
    }

    // 테스트용 오버로딩 함수
    public void setBonusNumber(String temp ){
        Validations.checkBonusNumberIsNumeric(temp);
        bonusNumber = Integer.parseInt(temp);

        Validations.checkBonusNumberDuplicate(bonusNumber, numbers);
        Validations.checkNumberRange(bonusNumber);
    }

    public List getNumbers(){
        return this.numbers;
    }
}