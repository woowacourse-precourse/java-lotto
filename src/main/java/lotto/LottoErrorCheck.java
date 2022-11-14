package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;

public class LottoErrorCheck {
    public static void moneyErrorCheck(String money){
        String numberPattern = "^[0-9]{1,}$";
        if(!Pattern.matches(numberPattern, money))
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야합니다.");

        if((Integer.parseInt(money) % 1000) != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야합니다.");
    }
    public static void winningNumberErrorCheck(List<String> numbers){
        if(numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");

        Set<String> duplicationCheck = new HashSet<>(numbers);
        if ( duplicationCheck.size() != numbers.size() )
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개는 서로 다른 숫자이어야 합니다.");

        String numberPattern = "^[0-9]{1,}$";
        for(int i=0 ; i < numbers.size() ; i++)
            if(!Pattern.matches(numberPattern, numbers.get(i)))
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 숫자를 입력해야 합니다.");

        int number;
        for(int i=0 ; i < numbers.size() ; i++){
            number = Integer.parseInt(numbers.get(i));
            if( number > 45 || number < 1 )
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }
    public static void bonusNumberErrorCheck(String number){
        String numberPattern = "^[0-9]{1,}$";
        if(!Pattern.matches(numberPattern, number))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");

        int num = Integer.parseInt(number);
        if( num > 45 || num < 1 )
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    public static void checkBonusNumberIncludedWinningNumber(List<Integer> winningNumber, Integer bonusNumber){
        if ( winningNumber.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다.");
    }
}
