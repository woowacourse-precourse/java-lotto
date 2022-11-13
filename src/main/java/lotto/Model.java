package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;

public class Model {
    /**
     * 1에서 45까지 서로 다른 임의의 수 6개의 로또 숫자를 생성한다.
     * @return 로또 숫자를 ArrayList로 return 한다.
     */
    private static ArrayList<Integer> CreateLottoNumber() {
        ArrayList<Integer> lottoNumber = new ArrayList<>();

        // 1에서 45까지 서로 다른 임의의 수 6개를 생성한다.
        while (lottoNumber.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumber.contains(randomNumber)) {
                lottoNumber.add(randomNumber);
            }
        }

        return lottoNumber;
    }

    /**
     * 집합에 사용자가가 입력한 숫자를 넣는다.
     * @param playerNumbers 사용자가가 입력한 숫자
     * @return 입력한 숫자를 HashSet로 return 한다.
     */
    public static HashSet<Integer> MakeNumberToSet(ArrayList<Integer> playerNumbers) {
        HashSet<Integer> playerNumber = new HashSet<>();

        // 집합에 사용자가가 입력한 숫자를 넣는다.
        for (Integer I : playerNumbers) {
            playerNumber.add(I);
        }

        return playerNumber;
    }

    public static Integer MakeStringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 유효하지 않습니다.");
        }
    }
}
