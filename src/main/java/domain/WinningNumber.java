package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumber {

    private final int winning_len = 11;

    public List<Integer> convertStringToList(String input){
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",");
        winningNumbers.add(Integer.parseInt(st.nextToken()));
        return winningNumbers;
    }
}
