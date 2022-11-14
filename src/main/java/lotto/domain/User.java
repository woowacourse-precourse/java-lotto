package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    static int money;

    public void GetMoney(){
        String money = readLine();
        CheckIfInteger(money);
        CheckIf1000(money);
    }

    public void getLotto(){
        String lotto = readLine();
        CheckLottoLength(lotto);


    }

    public void CheckLottoLength(String lotto){
        if(lotto.length() == 11) return;
        throw new IllegalArgumentException("[ERROR] 유저숫자 입력 - 로또 번호 길이 오류");
    }


    public void CheckIfInteger(String money){
        try{
            int moneyInt = Integer.parseInt(money);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 유저숫자 입력 - 문법 오류");
        }
    }

    private void CheckIf1000(String money){
        int moneyInt = Integer.parseInt(money);
        if(moneyInt % 1000 == 0) return;
        throw new IllegalArgumentException("[ERROR] 유저 숫자 입력 - 1000단위로 오류");
    }
}
