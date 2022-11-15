package lotto.model;

import lotto.Constant;

import java.util.ArrayList;
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
}
