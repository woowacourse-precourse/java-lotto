package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoManager {
    // 로또 구입 금액
    int money;
    // 로또 갯수
    int lottoCount;
    
    // 전체 동작을 구현하는 메소드
    public void run(){
        insertMoneyUI();
    }
    // 로또 구입 금액 입력이 유효한지 확인
    // 1. 숫자가 아닌 값 입력 시
    // 2. 1,000원 단위가 아닌 값 입력 시
    public boolean validateInsertMoney(String stringMoney){
        try{
            money = Integer.parseInt(stringMoney);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력했습니다.");
        }

        if(money<=0){
            throw new IllegalArgumentException("[ERROR] 자연수 값이여야 합니다.");
        }

        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }

        return true;
    }

    // 로또 구입 금액 입력받기
    public void insertMoney(String stringMoney){
        if(!validateInsertMoney(stringMoney)){
            throw new IllegalArgumentException("[ERROR] 입력 금액 유효성 검사 오류");
        }

        this.money = Integer.parseInt(stringMoney);
    }

    // 사용자로부터 로또 구입 금액 입력받는 메소드
    public void insertMoneyUI(){
        System.out.println("구입 금액을 입력해 주세요.");
        String stringMoney = readLine();
        insertMoney(stringMoney);
    }
}
