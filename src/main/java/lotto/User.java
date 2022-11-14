package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private final int lottoPrice = 1000;
    public int buyMoney;
    public int buyCount;
    public User(){
        System.out.println("구입금액을 입력해 주세요.");
        try{
            buyMoney = Integer.valueOf(Console.readLine());
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력해야합니다. 다음기회를 노려보세요.");
        }

        validate();
        buyCount = buyMoney/lottoPrice;
        System.out.println(String.format("%d개를 구매했습니다.",buyCount));
    }
    public void validate(){
        if (buyMoney%lottoPrice != 0 ){
            String errorPrint =String.format("[ERROR] 금액은 %d원 단위입니다.",lottoPrice);
            throw new IllegalArgumentException(errorPrint);
        }
    }

}
