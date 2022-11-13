package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Comparator {


    public List<Integer> compareLotto(List<List<Integer>> user, List<Integer> winNumber){
        List<Integer> correctNumberEachLotto = new ArrayList<>();

        for (int i = 0 ; i < user.size(); i ++) {
            List<Integer> gatherNumbers = new ArrayList<>();
            gatherNumbers.addAll(user.get(i));
            gatherNumbers.addAll(winNumber);
            int removeDuplicationSize = new HashSet(gatherNumbers).size();
            int duplicationNumber = gatherNumbers.size() - removeDuplicationSize;
            correctNumberEachLotto.add(duplicationNumber);
        }

        return correctNumberEachLotto;
    }
}
