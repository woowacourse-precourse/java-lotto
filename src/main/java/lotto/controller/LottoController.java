package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Rank.Rank;
import lotto.model.Money;
import lotto.model.WinningBonusNumber;
import lotto.model.WinningLottoNumbers;
import lotto.view.*;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private Money money;
    private WinningLottoNumbers winningLottoNumbers;
    private WinningBonusNumber winningBonusNumber;
    private InputView inputView;
    private OutputView outputView;
    private Lotto lotto;
    private List<Lotto> lottoList;
    private Rank[] ranks;

    // 인스턴스 접근과, 임포트 접근 후 함수 호출 방식의 차이점은?
    public LottoController() {
    }

    public void init() {
        money = new Money();
        inputView = new InputView();
        outputView = new OutputView();
        lottoList = new ArrayList<>();
        winningBonusNumber = new WinningBonusNumber();
        winningLottoNumbers = new WinningLottoNumbers();
        ranks = Rank.values();
    }

    public void run() {


        init();
        System.out.println(ranks);
        inputView.purchaseLotto();
//        InputView.purchaseLotto();
        int purchaseMoney = Integer.valueOf(Console.readLine());
//        System.out.println("purchaseMoney = " + purchaseMoney);
        saveMoney(purchaseMoney);
        System.out.println("money = " + money.getMoney());
        makeLottoNumbers(lottoList, purchaseMoney);

        outputView.lottoNumber(calculateLottoCount(money.getMoney()), lottoList);
        inputView.winnigNumber();
        String lottoNumbers = Console.readLine();
        saveWinningLottoNumbers(lottoNumbers);

        inputView.bonusNumber();
        String bonusNumber = Console.readLine();
        saveWinningBonusNumber(bonusNumber);
        System.out.println("winningBonusNumber.getBonusNumber = " + winningBonusNumber.getBonusNumber());

        compareTwoNumbers(winningLottoNumbers.getWinningLottoNumbers());
        checkLotto();
        


    }
    public void checkLotto() {
        for (Lotto l : lottoList) {
            compareTwoNumbers(l.getNumbers());
        }
    }
    public void compareTwoNumbers(List<Integer> lottoNumbers) {
        List<Integer> winningLottoNumber = winningLottoNumbers.getWinningLottoNumbers();
        int count = 0;
        for (int i = 0; i < winningLottoNumber.size(); i++) {//6ㄱㅐ
            if (i == winningLottoNumber.size() - 1 && count == 5 && lottoNumbers.contains(winningBonusNumber.getBonusNumber())) {
                ranks[3].increase();
            } else if (lottoNumbers.contains(winningLottoNumber.get(i))) {
                count++;
            }
        }
        for (int i = 0; i <= count - 3 && i != ranks.length - 1; i++) {
            if (i == 3) {
                continue;
            }
            ranks[i].increase();
        }
    }
    public void saveWinningBonusNumber(String bonusNumber) {
        winningBonusNumber.setBonusNumber(Integer.valueOf(bonusNumber));

    }
    public void saveWinningLottoNumbers(String lottoNumbers) {
        List<Integer> list = new ArrayList<>();
        String[] split = lottoNumbers.split(",");
        for (String s : split) {
            int number = Integer.valueOf(s);
            list.add(number);
        }
        winningLottoNumbers.setWinningLottoNumbers(list);
    }

    public void saveMoney(int purchaseMoney) {
        money.setMoney(purchaseMoney);
    }

    public int calculateLottoCount(int purchaseMoney) {
        return purchaseMoney / 1000;
    }

    public void makeLottoNumbers(List<Lotto> lottoList, int purchaseMoney) {
        int count = calculateLottoCount(purchaseMoney);
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            lottoList.add(new Lotto(numbers));
        }
    }

}
