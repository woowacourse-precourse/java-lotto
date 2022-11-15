package view;

import java.util.List;

public class PrintResult {
    public void printBuyLotto(int buyLottoNumber){
        System.out.println(buyLottoNumber + "개를 구매했습니다.");
    }

    public void printLottoNumber(List<Integer> lottoNumber){
        System.out.println(lottoNumber);
    }
}
