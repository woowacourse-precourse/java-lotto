package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoManager {
    private InputManager inputManager;
    private List<Lotto> lottos;
    private LottoMachine lottoMachine;

    public LottoManager(){
        this.inputManager = new InputManager();
    }

    public int startLotto() {
        HashMap<Integer, Integer> lottoResult = new HashMap<>();
        try {
            int amount = inputManager.getPurchasingAmount();
            lottos = buyLotto(amount);
            printLottos(amount, lottos);
            List<Integer> winningNumbers = inputManager.drawWinningNumbers();
            int bonusNumber = inputManager.drawBonusNumber(winningNumbers);
            lottoMachine = new LottoMachine(winningNumbers, bonusNumber);
            printLottoResult(lottoResult, lottos, lottoMachine, amount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);
            return 1;
        }
        return 0;
    }

    public int countBuyableLotto(int amount) {
        int count;
        count = amount / 1000;
        
        return count;
    }

    public List<Lotto> buyLotto(int amount) {
        int count = countBuyableLotto(amount);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(int amount, List<Lotto> lottos) {
        int count = countBuyableLotto(amount);
        printLottoCount(count);
        for (Lotto lotto : lottos) {
            Collections.sort(lotto.getNumbers());
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public int compareWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean compareBonusNumbers(Lotto lotto, int bonusNumbers) {
        if (lotto.getNumbers().contains(bonusNumbers)) {
            return true;
        }
        return false;
    }

    public void makeLottoResult(HashMap<Integer, Integer> lottoResult, Lotto lotto, LottoMachine lottoMachine) {
        List<Integer> winningNumbers = lottoMachine.getWinningNumbers();
        int bonusNumber = lottoMachine.getBonusNumbers();
        int countEqual = compareWinningNumbers(lotto, winningNumbers);
        boolean isBonusNumberEqual = compareBonusNumbers(lotto, bonusNumber);

        for (PrizeMoney prizeMoney : PrizeMoney.values()) {
            lottoResult.putIfAbsent(prizeMoney.getPrizeMoney(), 0);
            if (prizeMoney.getCountEqual() == countEqual && prizeMoney.getBonusNumberEqual() == isBonusNumberEqual) {
                lottoResult.merge(prizeMoney.getPrizeMoney(), 1, Integer::sum);
            }
        }
    }

    public double calculateRevenue(HashMap<Integer, Integer> lottoResult, int amount) {
        Set<Integer> prizeMoney = lottoResult.keySet();
        int totalPrize = 0;

        for (Integer prize : prizeMoney) {
            if (lottoResult.get(prize) > 0) {
                totalPrize += prize * lottoResult.get(prize);
            }
        }

        double revenue = (double) totalPrize / amount;

        return revenue;
    }

    public void printLottoResult(HashMap<Integer, Integer> lottoResult, List<Lotto> lottos, LottoMachine lottoMachine, int amount) {
        for (Lotto lotto: lottos) {
            makeLottoResult(lottoResult, lotto, lottoMachine);
        }
        double revenue = calculateRevenue(lottoResult, amount);

        printPrizeMoney(lottoResult);
        printRevenue(revenue);
    }

    public void printPrizeMoney(HashMap<Integer, Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (PrizeMoney prizeMoney : PrizeMoney.values()) {
            int countEqual = prizeMoney.getCountEqual();
            int count = lottoResult.get(prizeMoney.getPrizeMoney());
            String prize = prizeMoney.getPrizeMoneyOutput();
            boolean bonusNumber = prizeMoney.getBonusNumberEqual();
            if (bonusNumber) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개\n", countEqual, prize, count);
                continue;
            }
            System.out.printf("%d개 일치 (%s) - %d개\n", countEqual, prize, count);
        }
    }

    public void printRevenue(double revenue) {
        System.out.printf("총 수익률은 %.1f%%입니다.", revenue * 100);
    }
}
