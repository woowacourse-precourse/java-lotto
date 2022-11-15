package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            new Process();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
