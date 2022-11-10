package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    public static int getInputToInt(String readLine) {
        //예외 처리 추가 필요
        return Integer.parseInt(readLine);
    }

    public static List<Integer> getWinningNumber(String readLine) {
        String[] tempNumberList = readLine.split(",");
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            result.add(Integer.parseInt(tempNumberList[i]));
        }
        return result;
    }

}
