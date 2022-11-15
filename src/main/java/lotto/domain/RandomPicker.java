package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

/**
 * 미션에서 주어진 랜덤 방식을 통해서 숫자들을 선택해주는 클래스
 */
public final class RandomPicker implements PickNumbers {

    /**
     * 범위 안에 있는 숫자들을 겹치지 않게 뽑아주는 메서드
     *
     * @param startInclusive 시작범위에 해당하는 정수
     * @param endInclusive   끝 범위에 해당하는 정수
     * @param count          총 뽑아야 되는 정수의 수
     * @return 뽑은 결과에 해당하는 List<Integer>
     */
    @Override
    public List<Integer> pickUniquesInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
