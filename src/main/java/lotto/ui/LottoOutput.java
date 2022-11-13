package lotto.ui;

import java.util.List;

public class LottoOutput {
    public void printUserLotto(List<List<Integer>> userLotto) {
        StringBuilder sb = new StringBuilder();

        int amount = userLotto.size();

        sb.append(amount)
                .append(Messages.OUTPUT_USER_LOTTO.getMessage())
                .append("\n");

        for(List<Integer> lotto : userLotto) {
            sb.append(lotto).append("\n");
        }

        System.out.println(sb);
    }


}
