package lotto.domain;

import java.util.Arrays;
import java.util.List;

/**
 * packageName : lotto.domain
 * fileName : NumberCompare
 * author : gim-yeong-geun
 * date : 2022/11/10
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/10         gim-yeong-geun          최초 생성
 */
public class NumberCompare {
    // 몇 개의 숫자가 일치하는지 확인 기능
    public static Rank compare(List<Integer> numbers, List<Integer> randomNumbers, int bonusNumber) {
        int count = compareCount(numbers, randomNumbers);
        int bonusCount = compareBonusNumber(randomNumbers, bonusNumber);
        // 등수 입력
        return compareRank(count, bonusCount);
    }

    public static int compareCount(List<Integer> numbers, List<Integer> randomNumbers) {
        int count = 0;
        // numbers 와 randomNumbers 의 일치 개수 확인
        for(int i=0; i<6; i++){
            if (randomNumbers.contains(numbers.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    public static int compareBonusNumber(List<Integer> randomNumbers, int bonusNumber) {
        int bonusCount = 0;
        if (randomNumbers.contains(bonusNumber)) {
            bonusCount += 1;
        }
        return bonusCount;
    }

    public static Rank compareRank(int count, int bonusCount) {
        List<Rank> ranks = Arrays.asList(Rank.FIVE, Rank.FOUR, Rank.THREE, Rank.ONE);
        // 2등인 경우
        if(count == 5 && bonusCount == 1){
            return Rank.TWO;
        }
        // 2등이 아닌 경우
        for(int i=6; i>2; i--){
            if(i == count){
                return ranks.get(i-3);
            }
        }
        return Rank.LOSE;
    }
}
