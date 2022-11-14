package domain;

import exception.WinningExceptionType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumber {

    private final int winning_cnt = 6;
    private final int winning_len = 11;

    public List<Integer> convertStringToList(String input){
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",");
        winningNumbers.add(Integer.parseInt(st.nextToken()));
        return winningNumbers;
    }

    public void numberCount(List<Integer> list){
        HashSet<Integer> set = new HashSet<>(list);
        if(set.size() != winning_cnt){
            throw new IllegalArgumentException(WinningExceptionType.NOT_MATCH_NUMBER_COUNT.getErrorMessage());
        }
    }
}
