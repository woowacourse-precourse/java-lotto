package lotto.model;

import lotto.Constant;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main_Service {
    public Constant constant;

    public int get_NumberOfLotto(int money) {
        return money / constant.LOTTO_PRICE.getNum();
    }

    private List<Integer> make_Intersection(List<Integer> eachLottoNumbers, List<Integer> winNumbers) {
        List<Integer> intersection = new ArrayList<>(eachLottoNumbers);
        intersection.retainAll(winNumbers);
        return intersection;
    }

    private List<Integer> make_Difference(List<Integer> eachLottoNumbers, List<Integer> winNumbers) {
        List<Integer> difference = new ArrayList<>(eachLottoNumbers);
        difference.removeAll(winNumbers);
        return difference;
    }

    public int count_MatchingNumbers(List<Integer> eachLottoNumbers, List<Integer> winNumbers) {
        List<Integer> intersection = make_Intersection(eachLottoNumbers, winNumbers);
        return intersection.size();
    }

    private HashMap<Integer, List<Integer>> init_Map() {
        HashMap<Integer, List<Integer>> indexMap = new HashMap<>();
        indexMap.put(3, Arrays.asList(0));
        indexMap.put(4, Arrays.asList(1));
        indexMap.put(5, Arrays.asList(2, 3));
        indexMap.put(6, Arrays.asList(4));
        return indexMap;
    }

    private List<Integer> change_LottoToList(Lotto eachLotto) {
        return eachLotto.getNumbers();
    }

    private boolean check_Bonus(List<Integer> difference, int bonusNumber) {
        if (difference.contains(bonusNumber)) { // bonus까지 맞췄을 경우
            return true;
        }
        return false;
    }

    private int get_Index(List<Integer> eachLottoNumbers, List<Integer> winNumbers, int bonusNumber) {
        HashMap<Integer, List<Integer>> index_map = init_Map();
        List<Integer> difference = make_Difference(eachLottoNumbers, winNumbers);
        int match_cnt = count_MatchingNumbers(eachLottoNumbers, winNumbers);
        if (match_cnt < 3) {
            return -1;
        }
        if (match_cnt == 5) {
            if (check_Bonus(difference, bonusNumber)) {
                return index_map.get(match_cnt).get(1);
            }
            return index_map.get(match_cnt).get(0);
        }
        return index_map.get(match_cnt).get(0);
    }

    public int[] organize_Details(List<Lotto> all_Lotto, List<Integer> winNumbers, int bonusNumber) {
        int[] lotto_cnt = new int[5];
        for (Lotto eachLotto : all_Lotto) {
            int matchIndex = get_Index(change_LottoToList(eachLotto), winNumbers, bonusNumber);
            if (matchIndex != -1) {
                lotto_cnt[matchIndex] += 1;
            }
        }
        return lotto_cnt;
    }
}
