package lotto;

import java.util.List;

public class GetGrade {
    public boolean getBonus(List<Integer> numbers, int bonusNumber){
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) == bonusNumber)
                return true;
        }
        return false;
    }
    public int getGrade(List<Integer> winningNumber, List<Integer> numbers){
        int count = 0;

        for (int i = 0; i < numbers.size(); i++){
            count += checkNumber(numbers.get(i), winningNumber);
        }
        return count;
    }

    public int checkNumber(int getnumber, List<Integer> winningNumber){
        int count = 0;

        for (int i = 0; i < winningNumber.size(); i++){
            if (getnumber == winningNumber.get(i))
                count++;
        }
        return count;
    }
}
