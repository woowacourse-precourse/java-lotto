package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.ErrorMessage;
import lotto.ui.ManagerMessage;

public class Manager {
    private static final String SPLIT = ",";
    private static final int MIN_EXCLUSIVE = 1;
    private static final int MAX_EXCLUSIVE = 45;
    private List<Lotto> lottos;
    private List<Integer> win;

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(sort(numbers));
    }

    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<Integer>(numbers);
        sorted.sort(Comparator.naturalOrder());
        return sorted;
    }

    public void setLottos(int count) {
        lottos.clear();
        for (int i = 0; i < count; i++) {
            lottos.add(makeLotto());
        }
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void setWin() {
        System.out.println(ManagerMessage.INSERT_WIN_NUMBERS.getMessage());
        String input = readLine();
        try {
            win = sort(separateWinInput(input));
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.IllegalArgumentException.getMessage());
        }
    }

    private List<Integer> separateWinInput(String input) {
        List<Integer> result = new ArrayList<Integer>();
        List<String> splited = Arrays.asList(input.split(SPLIT));
        if (splited.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (String s : splited) {
            if (!Util.isInteger(s)) {
                throw new IllegalArgumentException();
            }
            int parsed = Integer.parseInt(s);
            if (isAddable(result, parsed)) {
                result.add(parsed);
            }
        }
        return result;
    }

    private boolean isAddable(List<Integer> list, int number) {
        // 중복값 검사
        if (!list.isEmpty() && list.get(list.size() - 1) == number) {
            throw new IllegalArgumentException();
        }
        if (!(number >= MIN_EXCLUSIVE && number <= MAX_EXCLUSIVE)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public List<Integer> getWin() {
        return win;
    }
}
