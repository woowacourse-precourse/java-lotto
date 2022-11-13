package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CompareHowManyCorrect {


    public List<Integer> compareLotto(List<List<Integer>> user, List<Integer> winNumber){
        List<Integer> correctNumberEachLotto = new ArrayList<>();

        for (int i = 0 ; i < user.size(); i ++) {
            List<Integer> gatherNumbers = new ArrayList<>();
            gatherNumbers.addAll(user.get(i));
            gatherNumbers.addAll(winNumber);
            correctNumberEachLotto.add(caculateDuplication(gatherNumbers));
        }

        return correctNumberEachLotto;
    }

    public int caculateDuplication(List<Integer> gather){

        int removeDuplicationSize = new HashSet(gather).size();
        int duplicationNumber = gather.size() - removeDuplicationSize;

        return duplicationNumber;
    }







}
