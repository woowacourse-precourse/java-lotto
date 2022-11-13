package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lucky {
    public List<Integer> compareNumbers(List<List<Integer>> user, List<Integer> com) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            int count = 0;
            for (int j = 0; j < user.get(i).size(); j++) {
                int num = user.get(i).get(j);
                if (com.contains(num)) {
                    count++;
                }
            }
            list.add(count);
        }
        return list;
    }

}
