package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoManager {
    // 로또 구입 금액
    int money;
    // 로또 갯수
    int lottoCount;
    
    // 전체 동작을 구현하는 메소드
    public void run(){
        // 로또 구입 금액 입력
        String stringMoney = readLine();
        //
        insertMoney(stringMoney);
    }

    // 로또 구입 금액 입력받기
    public void insertMoney(String stringMoney){
        int money = 0;
        try{
            money = Integer.parseInt(stringMoney);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력했습니다.");
        }

        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }

        this.money = money;
    }
}
