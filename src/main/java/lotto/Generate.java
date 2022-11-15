package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Generate {

    public static final int Start = 1;
    public static final int Finish = 45;
    public static final int cnt = 6;

    private Generate(){}

    public static List<Integer> MakeLotto() {
        List<Integer> lottoNbr = Randoms.pickUniqueNumbersInRange(Start, Finish, cnt);

        return lottoNbr;
    }

}