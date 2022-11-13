package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

public class LottoController {
    private LinkedList<Lotto> lottoPool = new LinkedList<>();

    public int readUserMoney(String userMoney) {
        isDigit(userMoney);
        validateUserMoney(userMoney);

        return Integer.parseInt(userMoney) / 1000;
    }

    public void createRandomLotto(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            Lotto newLotto = new Lotto(randomNumbers);
            lottoPool.add(newLotto);
        }
    }

    public void printLottoPool() {
        for (Lotto lotto : lottoPool) {
            System.out.println(lotto.toString());
        }
    }

    public Lotto readWinNumber(String userWinNumber) {
        StringTokenizer st = new StringTokenizer(userWinNumber, ",");
        ArrayList<Integer> winNumber = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String singleNumber = st.nextToken();
            isDigit(singleNumber);
            validateWinNumber(singleNumber);
            winNumber.add(Integer.parseInt(singleNumber));
        }

        Collections.sort(winNumber);
        return new Lotto(winNumber);
    }

    private void isDigit(String userInput) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, userInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다");
        }
    }

    private void validateWinNumber(String userInput) {
        int incomingNumber = Integer.parseInt(userInput);
        if (incomingNumber < 1 || incomingNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이여야 합니다");
        }
    }

    private void validateUserMoney(String userInput) {
        int money = Integer.parseInt(userInput);

        if (money == 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 이상의 금액을 입력해야 합니다");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 단위의 금액을 입력해야 합니다");
        }
    }
}
