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
}
