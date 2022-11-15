package view;

import java.util.HashMap;
import java.util.List;

public class PrintResult {
    private final String UNIT = "개";

    public void printBuyLotto(int buyLottoNumber){
        System.out.println(buyLottoNumber + "개를 구매했습니다.");
    }

    public void printLottoNumber(List<Integer> lottoNumber){
        System.out.println(lottoNumber);
    }

    enum NumberMatch {
        THREE("3개 일치 (5,000원) - ",5000),
        FORTH("4개 일치 (50,000원) - ", 50000),
        FIFTH("5개 일치 (1,500,000원) - ", 1500000),
        FIFTH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
        SIXTH("6개 일치 (2,000,000,000원) - ", 2000000000);

        private final String numberMatch;
        private final int money;

        private NumberMatch(String numberMatch, int money) {
            this.numberMatch = numberMatch;
            this.money = money;
        }

        public String getNumberMatch() {
            return this.numberMatch;
        }

        public int getMoney(){
            return this.money;
        }
    }

    public void printMatchDetail(HashMap matchNumbers) {
        List<Integer> order = List.of(3, 4, 5, 7, 6);
        for (NumberMatch numberMatch : NumberMatch.values()) {
            int idx = 0;
            System.out.println(numberMatch.getNumberMatch() + matchNumbers.get(order.get(idx)) + UNIT);
        }
    }
}
