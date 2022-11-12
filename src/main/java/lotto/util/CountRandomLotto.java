package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class CountRandomLotto {
    private static final WinningNumber winningNumber = new WinningNumber();
    private static final List<List<Integer>> myLotto=new ArrayList<>();

    public List<List<Integer>> calculate(int count){
        for(int i=0; i<count; i++){
            myLotto.add(winningNumber.RandomLotto());
            System.out.println(myLotto.get(i));
        }
        return myLotto;
    }
}