package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CompareHowManyCorrect {


    public List<Integer> correctNumberList(List<List<Integer>> user, List<Integer> winNumber, int bounsNumber){
        List<Integer> correctNumberEachLotto = new ArrayList<>();

        for (int i = 0 ; i < user.size(); i ++) {
            List<Integer> gatherLists = gatherTwoLists(user.get(i),winNumber);
            correctNumberEachLotto.add(caculateDuplication(gatherLists,bounsNumber));
        }

        return correctNumberEachLotto;
    }

    public int caculateDuplication(List<Integer> gather, int bounsNumber){ // 겹치는 숫자를 나중에 인덱스로 사용하기 위해, '6개 겹치는 경우'와 '5개 겹치고 1개 보너스인 경우'에 +1을 하여 구분 지었음.

        int removeDuplicationSize = new HashSet(gather).size();
        int duplicationNumber = gather.size() - removeDuplicationSize;

        if (duplicationNumber == 6 || (duplicationNumber == 5 && checkBonus(gather,bounsNumber))){
            duplicationNumber ++;
        }
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
