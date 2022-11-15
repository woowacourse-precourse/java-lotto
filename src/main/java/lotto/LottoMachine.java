package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoMachine {
    private Lotto winningLotto;
    private int bonus;
    private List<Lotto> issuedLotto;

    public LottoMachine() {

    }

    public void inputWinningLotto() {
        String winningLottoString = Console.readLine();
        String[] winningLottoStrings = winningLottoString.split(",");
        boolean winningLottoError = false;

        try {
            this.winningLotto = createWinningLotto(winningLottoStrings);
        } catch (Exception e) {
            winningLottoError = true;
            throw new IllegalArgumentException();
        } finally {
            if (winningLottoError) {
                System.out.println("[ERROR] 잘못된 로또번호 입력");
            }
        }
    }

    private static Lotto createWinningLotto(String[] winningLottoNumbers) {
        List<Integer> winningLottoList = new ArrayList<>();
        try {
            for (String winningString : winningLottoNumbers) {
                int winningNumber = Integer.parseInt(winningString);
                winningLottoList.add(winningNumber);
            }
            winningLottoList.sort(Comparator.naturalOrder());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return new Lotto(winningLottoList);
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }


    public void inputBonusNumber() {
        String bonusString = Console.readLine();
        boolean bonusError = false;
        try {
            this.bonus = Integer.parseInt(bonusString);
            checkBonusNumber();
        } catch (Exception e) {
            bonusError = true;
            throw new IllegalArgumentException();
        } finally {
            if (bonusError) {
                System.out.println("[ERROR] 잘못된 보너스 입력");
            }
        }
    }

    private void checkBonusNumber() {
        List<Integer> winningLottoList = this.winningLotto.getNumbers();
        if (winningLottoList.contains(this.bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonus() {
        return this.bonus;
    }


    public void issueLotto(int money) {
        int numberOfLotto = money / 1000;
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        this.issuedLotto = createIssuedLotto(numberOfLotto);
    }

    private static List<Lotto> createIssuedLotto(int numberOfLotto) {
        List<Lotto> issuedLotto = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> newLottoNumber = new LottoNumbers().generator();
            Lotto newLotto = new Lotto(newLottoNumber);
            issuedLotto.add(newLotto);
        }
        return issuedLotto;
    }

    public List<Lotto> getIssuedLotto() {
        return this.issuedLotto;
    }

    public void printIssuedLotto() {
        for (Lotto lotto : this.issuedLotto) {
            lotto.printLotto();
        }
    }
}
