package dto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import vo.*;

public class lotterydto {
    private List<List<Integer>> lottos = new ArrayList<>();
    public lotterydto(uservo vo) {
        int loop = vo.getCount();
        int i = 0;
        while(lottos.size() != loop) {
            List<Integer> temp = makelottery();
            if (validate(temp)) { this.lottos.add(temp); }
            System.out.println(temp);
        }
    }
    public List<List<Integer>> getLottos() { return lottos; }

    private List<Integer> makelottery() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private boolean validate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size() != 6) { return false; }
        return true;
    }

}
