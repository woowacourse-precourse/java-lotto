package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckWinningHistory {
    int firstPlace;
    int secondPlace;
    int thirdPlace;
    int fourthPlace;
    int fifthPlace;

    // 각 등수에 따른 상금 정리
    static final Integer[] prizeMoneys = {2000000000, 30000000, 1500000, 50000, 5000};

    CheckWinningHistory(){
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.fourthPlace = 0;
        this.fifthPlace = 0;
    }
    /** 클래스 내의 각 기능을 연결하는 메소드 추가 */
    void checkNumberMatching(ArrayList<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber){
        int sum = getTotalPrizeMoney(lottoList, winningNumbers, bonusNumber, 0);
        float earningsRate = getEarningsRate((float) lottoList.size() * 1000, (float) sum);
        printWinningHistory();
        printEarningsRate(earningsRate);
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
        if (diff.size() == 0){ this.firstPlace++; return this.prizeMoneys[0]; }
        if (diff.size() == 1){
            if (diff.get(0) == bonusNumber) {this.secondPlace++; return this.prizeMoneys[1];}
            this.thirdPlace++; return this.prizeMoneys[2];
        }
        if (diff.size() == 2){ this.fourthPlace++; return this.prizeMoneys[3]; }
        if (diff.size() == 3){ this.fifthPlace++; return this.prizeMoneys[4]; }
        return 0;
    }
    /** 구입금액과 당첨금을 비교해, 총 수익률을 계산해 반환하는 기능 */
    private float getEarningsRate(float purchasingAmount, float totalPrizeMoney){
        float earningsRate = (totalPrizeMoney/purchasingAmount) * 100;
        return earningsRate;
    }
    /** 당첨 내역을 출력하는 기능 */
    private void printWinningHistory() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 ("+ DecimalFormat.getInstance().format(this.prizeMoneys[4])+"원) - " + this.fifthPlace + "개");
        System.out.println("4개 일치 ("+ DecimalFormat.getInstance().format(this.prizeMoneys[3])+"원) - " + this.fourthPlace + "개");
        System.out.println("5개 일치 ("+ DecimalFormat.getInstance().format(this.prizeMoneys[2])+"원) - " + this.thirdPlace + "개");
        System.out.println("5개 일치, 보너스 볼 일치 ("+ DecimalFormat.getInstance().format(this.prizeMoneys[1])+"원) - " + this.secondPlace + "개");
        System.out.println("6개 일치 ("+ DecimalFormat.getInstance().format(this.prizeMoneys[0])+"원) - " + this.firstPlace + "개");
    }
    /** 총 수익률을 출력하는 기능 */
    private void printEarningsRate(float earningsRate) {
        System.out.printf("총 수익률은 ");
        System.out.println(String.format("%.1f", earningsRate) + "%입니다.");
    }
}
