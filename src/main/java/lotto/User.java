package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum WinningRanking{
    FIRST_WITHOUT_BONUS(1,6,0, 2_000_000_000),
    FIRST_WITH_BONUS(1,6,1, 2_000_000_000),
    SECOND(2,5,1, 30_000_000),
    THIRD_WITHOUT_BONUS(3,5,0, 1_500_000),
    THIRD_WITH_BONUS(3,5,1, 1_500_000),
    FOURTH_WITHOUT_BONUS(4,4,0, 50_000),
    FOURTH_WITH_BONUS(4,4,1, 50_000),
    FIFTH_WITHOUT_BONUS(5,3,0, 5_000),
    FIFTH_WITH_BONUS(5,3,1, 5_000);

    private final int order;
    private final int countMatches;
    private final int isMatchBonus;
    private final int prize;
    WinningRanking(int order, int countMatches, int isMatchBonus, int prize){
        this.order=order;
        this.countMatches=countMatches;
        this.isMatchBonus=isMatchBonus;
        this.prize=prize;
    }
    public List<Integer> getRanking(){
        return new ArrayList<>(List.of(countMatches, isMatchBonus));
    }
    public int getCountMatches(){
        return countMatches;
    }
    public int getIsMatchBonus(){
        return isMatchBonus;
    }
    public int getPrize(){
        return prize;
    }

}
public class User {
    private List<Lotto> lottos;
    private int price;
    private float earningRate;
    private int[] rankingCount=new int[5];


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
        List<Integer> numbers =Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
    private void calculateEarningRate(List<Integer> winningNumbers, int bonus){
        int sum=0;
        for (Lotto lotto:lottos) {
            WinningRanking ranking = getWinningRanking(lotto, winningNumbers, bonus);
            if (ranking!=null){
                sum+=ranking.getPrize();
            }
        }
        float temp = (float)(100.0*((float)sum/(float)lottos.size()));
        this.earningRate = Math.round(temp*10);
    }
}
