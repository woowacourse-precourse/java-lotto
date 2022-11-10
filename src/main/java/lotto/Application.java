package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoVendor lottoVendor=new LottoVendor();
        Buyer buyer=new Buyer();
        int purchaseMoney=Integer.parseInt(Console.readLine());
        buyer.purchase(lottoVendor,purchaseMoney);


    }
}
