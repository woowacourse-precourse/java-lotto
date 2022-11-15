package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.EnumCreate.MatchNumberAmount;

public class CorrectNumberCounter {
    MatchNumberAmount matchFiveBouns = MatchNumberAmount.FIVEBONUS;
    MatchNumberAmount matchSix = MatchNumberAmount.SIX;

    public List<Integer> makeCorrectNumberAmountList(List<List<Integer>> userLottoNumber, List<Integer> winNumber,
                                                     int bounsNumber) {

        List<Integer> correctNumberAmountList = new ArrayList<>();

        for (int i = 0; i < userLottoNumber.size(); i++) {
            List<Integer> listsCombination = gatherTwoLists(userLottoNumber.get(i), winNumber);
            correctNumberAmountList.add(countCorrectNumberAmount(listsCombination, bounsNumber));
        }

        return correctNumberAmountList;
    }

    public List<Integer> gatherTwoLists(List<Integer> userLottoNumber, List<Integer> winNumber) {
        List<Integer> userAndWinList = new ArrayList<>();
        userAndWinList.addAll(userLottoNumber);
        userAndWinList.addAll(winNumber);
        return userAndWinList;
    }

    public int countCorrectNumberAmount(List<Integer> listsCombination, int bounsNumber) {

        int removeDuplication = new HashSet(listsCombination).size();
        int correctNumber = listsCombination.size() - removeDuplication;

        if (correctNumber == matchSix.getNumber() - 1 || (correctNumber == matchFiveBouns.getNumber() - 1
                && checkBonus(listsCombination, bounsNumber))) {
            correctNumber++; // 겹치는 숫자 개수를 나중에 인덱스로 사용하기 위해, '6개 겹치는 경우'와 '5개 겹치고 1개 보너스인 경우'에 +1을 하여 구분 지었음.
        }

        return correctNumber;
    }


    public boolean checkBonus(List<Integer> user, int bounsNumber) {
        return user.contains(bounsNumber);
    }


}
