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

    public void startLotto() {
        HashMap<Integer, Integer> lottoResult = new HashMap<>();
        int amount = inputManager.getPurchasingAmount();
        int count = countBuyableLotto(amount);
        lottos = buyLotto(count);
        printLottoCount(count);
        printLottos(lottos);
        List<Integer> winningNumbers = inputManager.drawWinningNumbers();
        int bonusNumber = inputManager.drawBonusNumber();
        lottoMachine = new LottoMachine(winningNumbers, bonusNumber);
        printLottoResult(lottoResult, lottos, lottoMachine, amount);
    }

    public int countBuyableLotto(int amount) {
        int count;
        count = amount / 1000;
        
        return count;
    }

    public List<Lotto> buyLotto(int count) {
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

    public void printLottos(List<Lotto> lottos) {
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
        int countEqual = 0;
        boolean isBonusNumberEqual = false;

        countEqual = compareWinningNumbers(lotto, winningNumbers);
        isBonusNumberEqual = compareBonusNumbers(lotto, bonusNumber);

        List<Integer> prizeMoney = List.of(5000, 50000, 1500000, 30000000, 2000000000);

        for (Integer money : prizeMoney) {
            lottoResult.putIfAbsent(money, 0);
        }

        if (countEqual == 3) {
            lottoResult.merge(5000, 1, Integer::sum);
        } else if (countEqual == 4) {
            lottoResult.merge(50000, 1, Integer::sum);
        } else if (countEqual == 5 && !isBonusNumberEqual) {
            lottoResult.merge(1500000, 1, Integer::sum);
        } else if (countEqual == 5 && isBonusNumberEqual) {
            lottoResult.merge(30000000, 1, Integer::sum);
        } else if (countEqual == 6) {
            lottoResult.merge(2000000000, 1, Integer::sum);
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

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.get(5000) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.get(50000) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.get(1500000) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.get(30000000) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.get(2000000000) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", revenue * 100);
    }
}
