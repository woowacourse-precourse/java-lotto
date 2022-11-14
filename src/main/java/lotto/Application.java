package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    // 로또 자동번호 생성
    public List<HashSet<Integer>> createAutoNumbers(int numberOfPurchases) {
        List<HashSet<Integer>> autoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPurchases; i++) {
            autoNumbers.add((HashSet<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(autoNumbers.get(autoNumbers.size() - 1));
        }
        return autoNumbers;
    }

    // 보너스 번호 포함 당첨번호 생성
    public HashSet createWinningNumber(int bonusNumber, List<Integer> lottoNumber){
        if (!(1<= bonusNumber && bonusNumber <= 45)){
            throw new IllegalArgumentException();
        }
        HashSet<Integer> winningNumber = new HashSet<>(lottoNumber);
        winningNumber.add(bonusNumber);
        return winningNumber;
    }

    // 당첨 통계 생성
    public int[] createLottoStatistics(HashSet<Integer> winningNumber, List<HashSet<Integer>> autoNumbers){
        int[] lottoStatistics = new int[6];
        for(HashSet autoNumber: autoNumbers){
            autoNumber.retainAll(winningNumber);
            if (autoNumber.size() >= 3){
                lottoStatistics[autoNumber.size()] += 1;
            }
        }
        return lottoStatistics;
    }

    public enum prize {
        
    }
    // 통계값 출력
    public void printLottoStatistics(int[] lottoStatistics, int numberOfPurchases){
        int totalPrize = 0;
        for(int i = 3; i < lottoStatistics.length; i++){
            System.out.println(String.format("%d개 일치 () - %d개", i, lottoStatistics[i]));
            totalPrize += i * lottoStatistics[i];
        }
        System.out.println(String.format("총 수익률은 %d%입니다.", totalPrize/(numberOfPurchases*1000)));
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
