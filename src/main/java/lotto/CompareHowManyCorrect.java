package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CompareHowManyCorrect {


    public List<Integer> compareLotto(List<List<Integer>> user, List<Integer> winNumber){
        List<Integer> correctNumberEachLotto = new ArrayList<>();

        for (int i = 0 ; i < user.size(); i ++) {
            List<Integer> gatherLists = gatherTwoLists(user.get(i),winNumber);
            correctNumberEachLotto.add(caculateDuplication(gatherLists));
        }

        return correctNumberEachLotto;
    }

    public int caculateDuplication(List<Integer> gather){

        int removeDuplicationSize = new HashSet(gather).size();
        int duplicationNumber = gather.size() - removeDuplicationSize;

        return duplicationNumber;
    }


    public List<Integer> gatherTwoLists(List<Integer> user, List<Integer> winNumber){
        List<Integer> gatherLists = new ArrayList<>();
        gatherLists.addAll(user);
        gatherLists.addAll(winNumber);
        return gatherLists;
    }

    public boolean checkBonus(List<Integer> user, int bounsNumber){
        return user.contains(bounsNumber);
    }







}
