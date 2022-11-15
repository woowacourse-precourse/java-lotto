package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private List<Integer> winningNumber = new ArrayList<>();
    private int bonusNumber;

    public List<Lotto> buyLotto(int money) {
        System.out.println(money / 1000 + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }

        return lottos;
    }

    public Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public void setWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        winningNumber = checkWiningNumber(input);
    }

    public List<Integer> checkWiningNumber(String input) {
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

    public void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String bonusNumberInput = Console.readLine();
        System.out.println();
        this.bonusNumber = checkBonusNumber(bonusNumberInput);
    }

    public int checkBonusNumber(String bonusNumberInput) {
        int bonusNumber = convertStringToInt(bonusNumberInput);
        isNumberCorrectRange(bonusNumber);
        isBonusNumberDuplicatedWithWinningNumber(bonusNumber);

        return bonusNumber;
    }

    private void isBonusNumberDuplicatedWithWinningNumber(int bonusNumber) {
        if (this.winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 넘버가 당첨 번호와 중복이 있으면 안됩니다.");
        }
    }

    public Winning isLottoWin(Lotto lotto) {
        int winningNumberCount = getWinningNumberCount(lotto);
        if(winningNumberCount == 3)
            return Winning.fifth;
        if(winningNumberCount == 4)
            return Winning.fourth;
        if (winningNumberCount == 5) {
            if(isBonusNumberInLotto(lotto))
                return Winning.second;
            return Winning.third;
        }
        if(winningNumberCount == 6)
            return Winning.first;
        return null;
    }

    private boolean isBonusNumberInLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        }

        return false;
    }
    private int getWinningNumberCount(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int winningNumberCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumber.contains(lottoNumber)) {
                winningNumberCount++;
            }
        }
        return winningNumberCount;
    }
}
