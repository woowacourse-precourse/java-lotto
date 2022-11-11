package lotto.domain;

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
        if (count == 6) {
            return Rank.ONE;
        }
        if (count == 5 && bonusCount == 1) {
            return Rank.TWO;
        }
        if (count == 5) {
            return Rank.THREE;
        }
        if (count == 4) {
            return Rank.FOUR;
        }
        if (count == 3) {
            return Rank.FIVE;
        }
        return Rank.LOSE;
    }

    public static int compareCount(List<Integer> numbers, List<Integer> randomNumbers) {
        int i = 0;
        int count = 0;
        // numbers 와 randomNumbers 의 일치 개수 확인
        while (true) {
            if (randomNumbers.contains(numbers.get(i))) {
                count += 1;
            }
            i++;
            if (i == 5) {
                break;
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

}
