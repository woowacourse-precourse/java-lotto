package lotto;

import java.util.ArrayList;
import java.util.List;

public class FinalUserNumberGenerator {

    public static List<List<Integer>> FinalUserNumber(int InputMoney) {
        List<List<Integer>> correctNumberList = new ArrayList<>();
        for(int i=0; i<InputMoney; i++) {
            List<Integer> UserPickNumber = UserNumberGenerator.createRandomNumbers();
            correctNumberList.add(UserPickNumber);
        }
        return correctNumberList;



    }
}
