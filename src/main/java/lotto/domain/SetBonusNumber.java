package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Compare;
import lotto.ui.WinningCount;
import java.util.List;

// 보너스 번호
public class SetBonusNumber{
    int[] arrCount = new int[5];
    public SetBonusNumber(int count, List<List<Integer>> lottoNumbers, boolean bonusCheck, Compare[] compare){
        int winningGrade = 0;
        WinningCount winningCount = new WinningCount();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = lottoNumbers.get(i);
            Bonus bonus = new Bonus(lottoNumber, bonusNumber);
            bonusCheck = bonus.getBonusCheck();

            // 당첨 내역 구하기
            winningCount.init();
            winningGrade = winningCount.count(compare[i].getSame(), bonusCheck);
            if (winningGrade == -1) continue;
            arrCount[winningGrade]++;
        }
    }
    public int[] getArrCount(){
        return arrCount;
    }
}