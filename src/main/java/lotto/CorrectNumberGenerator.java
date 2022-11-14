package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;


public class CorrectNumberGenerator {

    public static List<Integer> createCorrectNumber() {
        List<Integer> CorrectNumber = InputCorrectNumberGenerator.createInputCorrectNumber();
        pickNumberInList(CorrectNumber);

        return CorrectNumber;
    }
}
