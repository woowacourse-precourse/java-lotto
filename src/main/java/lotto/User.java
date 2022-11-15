package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int price;
    private float earningRate;
    private int[] rankingCount=new int[] {0, 0,0,0,0,0};


    public User(int price) {
        validatePrice(price);
        this.price = price;

        lottos = new ArrayList<Lotto>();
        int countLottos = price/1000;

        for (int i=0; i<countLottos;i++){
            lottos.add(new Lotto(createNumbers()));
        }
        System.out.printf("%d개를 구매했습니다.\n", countLottos);
    }

    private void validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수일 수 없습니다.");
        }
        if (price <= 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원입니다.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력 할 수 있습니다.");
        }
    }

    private List<Integer> createNumbers() {
        List<Integer> numbers =new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }
    public void printNumbersOfLottos(){
        for (Lotto lotto: this.lottos) {
            lotto.printNumbers();
        }
    }
    private WinningRanking getWinningRanking(Lotto lotto, List<Integer> winningNumbers, int bonus){
        List<Integer> coincidenceNumber = lotto.countCoincidence(winningNumbers,bonus);
        WinningRanking result = null;
        for (WinningRanking winningRanking: WinningRanking.values()) {
            if (winningRanking.getRanking().equals(coincidenceNumber)){
                result=winningRanking;
            }
        }
        return result;
    }
    public void calculateEarningRate(List<Integer> winningNumbers, int bonus){
        int sum=0;
        for (Lotto lotto:lottos) {
            WinningRanking ranking = getWinningRanking(lotto, winningNumbers, bonus);
            if (ranking!=null){
                sum+=ranking.getPrize();
                rankingCount[ranking.getOrder()]=rankingCount[ranking.getOrder()]+1;
            }
        }
        float temp = (float)(100.0*((float)sum/(float)this.price));
        this.earningRate = Math.round(temp*10)/(float)10.0;
    }
    public void printPrizeResult(){
        System.out.println("\n당첨 통계\n---");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.printf("3개 일치 (%s원) - %d개\n", decimalFormat.format(WinningRanking.FIFTH_WITHOUT_BONUS.getPrize()),
                this.rankingCount[WinningRanking.FIFTH_WITHOUT_BONUS.getOrder()]);
        System.out.printf("4개 일치 (%s원) - %d개\n", decimalFormat.format(WinningRanking.FOURTH_WITHOUT_BONUS.getPrize()),
                this.rankingCount[WinningRanking.FOURTH_WITHOUT_BONUS.getOrder()]);
        System.out.printf("5개 일치 (%s원) - %d개\n", decimalFormat.format(WinningRanking.THIRD_WITHOUT_BONUS.getPrize()),
                this.rankingCount[WinningRanking.THIRD_WITHOUT_BONUS.getOrder()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", decimalFormat.format(WinningRanking.SECOND.getPrize()),
                this.rankingCount[WinningRanking.SECOND.getOrder()]);
        System.out.printf("6개 일치 (%s원) - %d개\n", decimalFormat.format(WinningRanking.FIRST_WITHOUT_BONUS.getPrize()),
                this.rankingCount[WinningRanking.FIRST_WITHOUT_BONUS.getOrder()]);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", this.earningRate);
    }
}
