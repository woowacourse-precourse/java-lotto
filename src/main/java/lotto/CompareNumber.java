package lotto;

import java.util.List;

public class CompareNumber {
    public static int jugementNumber(List<Integer> UserPickNumber, List<Integer> CorrectNumber) {
        int returnNumber = 0;

        for(int i=0; i<CorrectNumber.size(); i++) {
            if (CorrectNumber.contains(UserPickNumber.get(i))) {
                returnNumber += 1;
            }
        }
        return returnNumber;
    }
}