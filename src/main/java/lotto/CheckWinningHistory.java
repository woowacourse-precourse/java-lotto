package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckWinningHistory {
    int firstPlace;
    int secondPlace;
    int thirdPlace;
    int fourthPlace;
    int fifthPlace;

    CheckWinningHistory(){
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.fourthPlace = 0;
        this.fifthPlace = 0;
    }
    /** 총 당첨금을 계산하는 기능 */
    private int getTotalPrizeMoney(ArrayList<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber, int sum) {
        for (int i =0;i<lottoList.size();i++){
            List<Integer> targetLotto = lottoList.get(i).getNumbers();
            // lottoList - winningNumbers 인 차집합을 생성한다(각 로또의 번호와 당첨번호를 비교).
            List<Integer> diff = targetLotto.stream()
                    .filter(j -> !winningNumbers.contains(j))
                    .collect(Collectors.toList());
            sum += checkPrizeMoney(diff, bonusNumber);
        }
        return sum;
    }
    /** 해당 로또의 당첨 내역을 반환하는 기능 */
    private int checkPrizeMoney(List<Integer> diff, int bonusNumber){
        if (diff.size() == 0){ this.firstPlace++; return 2000000000; }
        if (diff.size() == 1){
            if (diff.get(0) == bonusNumber) {this.secondPlace++; return 30000000;}
            this.thirdPlace++; return 1500000;
        }
        if (diff.size() == 2){ this.fourthPlace++; return 50000; }
        if (diff.size() == 3){ this.fifthPlace++; return 5000; }
        return 0;
    }
    /** 구입금액과 당첨금을 비교해, 총 수익률을 계산해 반환하는 기능 */
    private float getEarningsRate(float purchasingAmount, float totalPrizeMoney){
        float earningsRate = (totalPrizeMoney/purchasingAmount) * 100;
        return earningsRate;
    }
}
