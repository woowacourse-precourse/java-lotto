package lotto;

import java.util.List;

public class CompareLotto {
    public static int[] comparelotto(List<List<Integer>> total, String[] lottolst, int bonus) {
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < total.size(); i++) {
            int cnt = 0;
            for (int j = 0; j < 6; j++) {
                if (total.get(i).contains(Integer.parseInt(lottolst[j]))) {
                    cnt += 1;
                }
            }
            //보너스 번호 확인
            if (cnt == 5) {
                if (total.get(i).contains(bonus)) {
                    result[7] += 1;

                }
            } else {
                result[cnt] += 1;
            }
    }
        return result;
}


}