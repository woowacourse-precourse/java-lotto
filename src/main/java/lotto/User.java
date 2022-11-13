package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private final int lottoPirce = 1000;
    public int buyMoney;
    public int buyCount;
    public User(){
        System.out.println("구입금액을 입력해 주세요.");
        buyMoney = Integer.valueOf(Console.readLine());
        validate();
        buyCount = buyMoney/lottoPirce;
        System.out.println(String.format("%d개를 구매했습니다.",buyCount));
    }
    public void validate(){
        if (buyMoney%lottoPirce != 0 ){
            String errorPrint =String.format("[ERROR] 금액은 %d원 단위입니다.",lottoPirce);
            throw new IllegalArgumentException(errorPrint);
        }
    }

}
