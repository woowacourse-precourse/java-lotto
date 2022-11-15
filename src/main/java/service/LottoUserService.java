package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoUserService {
    final static int MAX_LOTTO_LENGTH = 6;

    // 사용자 추첨 번호 저장하기
    public List<List<Integer>> saveUserRandomNumbers(int count, List<List<Integer>> userRandomNumbers) {
        for (int i = 1; i <= count; i++) {
            userRandomNumbers.add(makeUserRandomNumbers());
        }
        return userRandomNumbers;
    }

    // 사용자 추첨 번호 생성
    public List<Integer> makeUserRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    // 입력된 당첨 번호 추출하기
    public List<Integer> changeTypeOfWinningNumbers(String[] tempWinningNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < MAX_LOTTO_LENGTH; i++) {
            numbers.add(Integer.parseInt(tempWinningNumbers[i]));
        }

        return numbers;
    }
}
