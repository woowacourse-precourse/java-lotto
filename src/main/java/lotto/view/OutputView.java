package lotto.view;

import java.util.List;

public class OutputView {
    public void printException(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printLottoQuantity(int lottoQuantity){
        System.out.println(String.valueOf(lottoQuantity)+"개를 구매했습니다.");
    }

    public void printLotto(List<Integer> purchaserLotto) {
        System.out.print("[");

        for(int i=0;i<6;i++){
            System.out.print(purchaserLotto.get(i));
            if(i!=5){
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
