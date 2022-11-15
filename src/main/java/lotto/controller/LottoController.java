package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Rank.Rank;
import lotto.model.Money;
import lotto.model.WinningBonusNumber;
import lotto.model.WinningLottoNumbers;
import lotto.utils.Validates;
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
    private StatisticsView statisticsView;
    private Validates validates;
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
        statisticsView = new StatisticsView();
        lottoList = new ArrayList<>();
        winningBonusNumber = new WinningBonusNumber();
        winningLottoNumbers = new WinningLottoNumbers();
        ranks = Rank.values();
        validates = new Validates();
    }
    public void inputPurchaseMoney() {
        inputView.purchaseLotto();
        try{
            int purchaseMoney = Integer.parseInt(Console.readLine());
            if (validates.validatePurchaseMoney(purchaseMoney)) {
                saveMoney(purchaseMoney);
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 구입 금액이 올바르지 않습니다.");
            throw e;
        }


    }
    public void run() {
        init();
        inputPurchaseMoney();
        makeLottoNumbers(lottoList, money.getMoney());
        outputView.lottoNumber(calculateLottoCount(money.getMoney()), lottoList);
        inputView.winnigNumber();
        String lottoNumbers = Console.readLine();
        saveWinningLottoNumbers(lottoNumbers);

        inputView.bonusNumber();
        String bonusNumber = Console.readLine();
        saveWinningBonusNumber(bonusNumber);

        compareTwoNumbers(winningLottoNumbers.getWinningLottoNumbers());
        checkLotto();
        statisticsView.printResult(ranks,calculateYield(money.getMoney()));


    }
    public double calculateYield(int purchaseMoney) {
        double sum = 0;
        for (Rank rank : ranks) {
            sum += rank.getCount() * rank.getPrizeMoney();
        }
        double yield = sum / purchaseMoney * 100;
        yield = Math.round((yield * 100)) / 100.0;
        return yield;
    }
    public void checkLotto() {
        for (Lotto l : lottoList) {
            compareTwoNumbers(l.getNumbers());
        }
    }
    public void compareTwoNumbers(List<Integer> lottoNumbers) {
        List<Integer> winningLottoNumber = winningLottoNumbers.getWinningLottoNumbers();
        int count = 0;
        int bonus=0;
        for (int i = 0; i < winningLottoNumber.size()-1; i++) {//6ㄱㅐ
            if (lottoNumbers.contains(winningLottoNumber.get(i))) {
                count++;
            }
            if (lottoNumbers.contains(winningBonusNumber.getBonusNumber())) {
                bonus++;
            }
        }
        if(count <3) return;
            if (bonus == 1 && count == 6) {
                System.out.println("bonus");
                ranks[3].increase();
            }else if(bonus == 0 && count == 6){
                ranks[4].increase();
            }
            else if(bonus == 0){
                ranks[count - 3].increase();
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
