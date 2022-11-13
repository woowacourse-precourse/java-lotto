package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Lotto {
    //final은 값이 변하지 않는다. 객체를 생성하고 Lotto를 호출했을 때 넣은 numbers 그대로 유지하게 된다.
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    // 당첨 통계 생성
    public int[] lottoStatistics(int bonusNumber, List<HashSet<Integer>> lottoNumbers){
        int[] statistics = new int[6];
        HashSet winningNumbers = winningNumber(bonusNumber);
        validateNumberRange(winningNumbers);
        for(HashSet autoLotto: lottoNumbers){
            autoLotto.retainAll(winningNumbers);
            if (autoLotto.size() >= 3){
                statistics[autoLotto.size()] += 1;
            }
        }
        return statistics;
    }

    // 로또 자동번호 생성
    public List<HashSet<Integer>> lottoNumber(int numberOfPurchases){
        List<HashSet<Integer>> lottoNumbers = new ArrayList<>();
        for(int i = 0; i < numberOfPurchases; i++){
            lottoNumbers.add((HashSet<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(lottoNumbers.get(lottoNumbers.size()-1));
        }
        return lottoNumbers;
    }
    // 보너스 번호 포함 당첨번호 생성
    private HashSet winningNumber(int bonusNumber){
        HashSet<Integer> winningNumbers = new HashSet<>(numbers);
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }

    // 보너스 번호 포함 당첨번호 범위 확인
    private void validateNumberRange(HashSet<Integer> winningNumbers) {
        winningNumbers.stream().filter(n -> n > 45 || n < 0).findAny()
                .ifPresent(m -> {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                });
    }


}
