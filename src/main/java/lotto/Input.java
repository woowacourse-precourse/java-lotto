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
    public int getCash(){
        String cash=Console.readLine();
        numberRegex(cash);
        return cashUnit(cash);
    }
    public List<Integer> getWinningNumbers(){
        String winningNumbers=Console.readLine();
        return winningNumberFilter(winningNumbers);
    }
    public int getBonusNumber(List<Integer> winningNumber){
        String bonusNumber=Console.readLine();
        numberRegex(bonusNumber);
        numberDuplicateCheck(winningNumber,bonusNumber);
        return NumberRange(bonusNumber);
    }
    private List<Integer> winningNumberFilter(String winningNumbers){
        Set<Integer> Numbers = new HashSet<>();
        for (String number: winningNumbers.split(",")){
            numberRegex(number);
            Numbers.add(NumberRange(number));
        }
        return new ArrayList<>(Numbers);
    }
    private void numberDuplicateCheck(List<Integer> winningNumber,String bonusNumber){
        int number =Integer.parseInt(bonusNumber);
        if(winningNumber.contains(number)) throw new IllegalArgumentException("[ERROR] 입력 값이 당첨 번호와 중복됩니다.");
    }
    private int NumberRange(String number){
        int checkNumber=Integer.parseInt(number);
        if(checkNumber<1 || checkNumber>45)
            throw new IllegalArgumentException("[ERROR] 입력 값이 범위가 아닙니다.");
        return checkNumber;
    }
    private void numberRegex(String cash){
        pattern = Pattern.compile("^[0-9]+$");
        matcher = pattern.matcher(cash);
        if(!matcher.matches())
            throw new IllegalArgumentException("[ERROR] 입력 값이 숫자가 아닙니다.");
    }
    private int cashUnit(String cash){
        int money=Integer.parseInt(cash);
        if(money%1000 !=0 || money==0)
            throw new IllegalArgumentException("[ERROR] 입력하신 금액은 1,000원 단위가 아닙니다.");
        return money;
    }
}