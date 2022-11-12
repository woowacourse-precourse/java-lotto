package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winning {

    public void score() {

    }

    public double rate() {
        return 0;
    }

    public List winning(String win) {
        List<Integer> list = new ArrayList<>();

        String[] split = win.split(",");

        for (int i=0; i<split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }

        return list;
    }
}
