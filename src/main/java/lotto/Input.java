package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private Pattern pattern;
    private Matcher matcher;
    //구입 금액 입력
    public int getCash(){
        String cash=Console.readLine();
        NumberRegex(cash);
        return cashUnit(cash);
    }
    public List<Integer> getWinningNumbers(){//당첨 번호 입력
        String winningNumbers=Console.readLine();
        return winningNumberFilter(winningNumbers);
    }
    public int getBonusNumber(){return NumberRange(Console.readLine());}
    private List<Integer> winningNumberFilter(String winningNumbers){
        Set<Integer> Numbers = new HashSet<>();
        for (String number: winningNumbers.split("-")) {
            NumberRegex(number);
            Numbers.add(NumberRange(number));
        }
        return new ArrayList<>(Numbers);
    }
    private int NumberRange(String number){
        int checkNumber=Integer.parseInt(number);
        if(checkNumber>0&&checkNumber<46)
            throw new IllegalArgumentException("[ERROR] 입력 값이 범위가 아닙니다.");
        return checkNumber;
    }
    private void NumberRegex(String cash){ //입력 값이 숫자인지
        pattern = Pattern.compile("^[0-9]+$");
        matcher = pattern.matcher(cash);
        if(!matcher.matches())
            throw new IllegalArgumentException("[ERROR] 입력 값이 숫자가 아닙니다.");
    }
    private int cashUnit(String cash){ //입력 금액 단위 확인
        int money=Integer.parseInt(cash);
        if(money%1000 !=0)
            throw new IllegalArgumentException("[ERROR] 입력하신 금액은 1,000원 단위가 아닙니다.");
        return money;
    }
}