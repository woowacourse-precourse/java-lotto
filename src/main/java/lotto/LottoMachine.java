package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private List<Integer> winningNumber = new ArrayList<>();

    public List<Lotto> buyLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    public Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void setWinningNumber() {
        String input = Console.readLine();
        winningNumber = checkWiningNumber(input);
    }

    private List<Integer> checkWiningNumber(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        if (st.countTokens() != 6)
            throw new IllegalArgumentException("[ERROR] 6개의 수를 입력해야 합니다.");

        return convertStringTokenizerToIntegerList(st);

    }

    private List<Integer> convertStringTokenizerToIntegerList(StringTokenizer st) {
        List<Integer> winningNumber = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int number = convertStringToInt(st.nextToken());
            isNumberCorrectRange(number);
            winningNumber.add(number);
        }
        isDuplicateNumberList(winningNumber);

        return winningNumber;
    }

    private int convertStringToInt(String s) {
        try {
            int number = Integer.parseInt(s);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 수를 입력해야 합니다.");
        }
    }

    private void isNumberCorrectRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 수를 입력해야 합니다.");
        }
    }

    private void isDuplicateNumberList(List<Integer> winningNumber) {
        Set<Integer> checker = new HashSet<>();
        for (Integer number : winningNumber) {
            if (!checker.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 수를 입력하면 안됩니다.");
            }
        }
    }


}
