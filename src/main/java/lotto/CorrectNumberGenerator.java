package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;


public class CorrectNumberGenerator {

    public static List<Integer> createCorrectNumber() {
        try {
            List<Integer> CorrectNumber = InputCorrectNumberGenerator.createInputCorrectNumber();
            pickNumberInList(CorrectNumber);
            return CorrectNumber;
        }  catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
