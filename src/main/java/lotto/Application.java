package lotto;

import java.util.List;

public class Application {
//사용자가 로또는 몇개를 구매했는지 확인하는 메서드
    public static int countBuyGame(int buyMoney){
        int returnData = buyMoney / 1000;
        int remainder = buyMoney % 1000;
        if(remainder != 0){
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위로 입력가능합니다.");
        }
        return returnData;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoWin a = LottoWin.getInstance();
        int[] b_1 = {1000,1900};
        int[] b_2 = {1000,2000};
        int[] b_3 = {1000,2000};
        List<int[]> b = List.of(b_1,b_2,b_3);

        a.profitRateCal(b);
        System.out.println(a.getLottoNum());

    }
}
