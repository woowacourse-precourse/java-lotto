package domain;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumber {

    private final int winning_cnt = 6;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;

    public List<Integer> validateWinningNumbers(String input){
        notNumber(input);
        notComma(input);
        List<Integer> winningNumbers = convertStringToList(input);
        numberCount(winningNumbers);
        numberRange(winningNumbers);

        return winningNumbers;
    }

    public List<Integer> convertStringToList(String input){
        List<Integer> winningNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",");
        for (int i = 0; i < winning_cnt; i++) {
            winningNumbers.add(Integer.parseInt(st.nextToken()));
        }
        return winningNumbers;
    }

    public void numberCount(List<Integer> list){
        HashSet<Integer> set = new HashSet<>(list);
        if(set.size() != winning_cnt){
            throw new IllegalArgumentException();
        }
    }

    public void numberRange(List<Integer> list){
        for(int num : list){
            if(num < MIN_NUMBER || num > MAX_NUMBER){
                throw new IllegalArgumentException();
            }
        }
    }

    public void notNumber(String input){
        for (int i = 0; i < input.length(); i+=2) {
            if(input.charAt(i) < 48 || input.charAt(i) > 57){
                throw new IllegalArgumentException();
            }
        }
    }

    public void notComma(String input){
        for (int i = 1; i < input.length()-1; i+=2) {
            if(input.charAt(i) != ','){
                throw new IllegalArgumentException();
            }
        }
    }
}
