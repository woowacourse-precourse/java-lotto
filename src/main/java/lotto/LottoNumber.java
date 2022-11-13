package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoNumber {
    private int lottoNumber;


    public void LottoBuyPriceInput(){
        System.out.println("구입금액을 입력해 주세요.");
        String buyPrice = Console.readLine();
        int lottoNum = Integer.parseInt(buyPrice) / 1000;
        lottoNumber = lottoNum;
        System.out.println(lottoNum + "개를 구매했습니다.");
    }


}
