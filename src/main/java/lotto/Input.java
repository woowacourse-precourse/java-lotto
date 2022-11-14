package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private Pattern pattern;
    private Matcher matcher;
    //구입 금액 입력
    public int getCash(){
        String cash=Console.readLine();
        cashRegex(cash);
        return cashUnit(cash);
    }
    private void cashRegex(String cash){ //입력 값이 숫자인지
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
    //당첨 번호 입력
    //보너스 번호 입력
}
//정규화에 따른 test 생성