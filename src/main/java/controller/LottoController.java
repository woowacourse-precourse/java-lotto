package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.*;
import vo.LottoRanking;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {
    Validator validator = new Validator();

    private static final String PURCHASE_MESSAGE = "";


    public void run() {
        int lottoCount = buyLotto();
        ArrayList<Lotto> lottos = publishLotto(lottoCount);

        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber());
        validator.validateReference(winningNumbers.getWinningNumbers(), bonusNumber.getBonusNumber());

        HashMap<LottoRanking, Integer> winningList = makeWinningList(lottos, winningNumbers, bonusNumber);
        printWinningList(winningList);
    }

    public int buyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        String userMoney = Console.readLine();
        validator.validateMoneyNumber(userMoney);
        validator.validateMoneyUnit(userMoney);
        Money money = new Money(userMoney);
        return money.getLottoCount();
    }

    public ArrayList<Lotto> publishLotto(int count) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        System.out.printf("%d개를 구매했습니다.\n", count);
        LottoMaker lottoMaker = new LottoMaker();
        for (int i = 0; i < count; i++) {
            Lotto lotto = lottoMaker.makeLotto();
            lottos.add(lotto);
            ArrayList<Integer> printNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(printNumbers);
            System.out.println(printNumbers);
        }
        return lottos;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        validator.validateWinningNumberComma(winningNumber);

        List<Integer> winningNumbers = Arrays.stream(Arrays.stream(winningNumber.split(","))
                        .mapToInt(Integer::parseInt).toArray())
                .boxed().collect(Collectors.toList());

        validator.validateWinningNumberSize(winningNumbers);
        validator.validateWinningNumberRange(winningNumbers);
        validator.validateWinningNumberReference(winningNumbers);
        return winningNumbers;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String bonusNumber = Console.readLine();
        validator.validateBonusNumberRange(bonusNumber);
        return bonusNumber;
    }

    public HashMap<LottoRanking, Integer> makeWinningList(ArrayList<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {

        HashMap<LottoRanking, Integer> winningList = new HashMap<>();
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            winningList.put(lottoRanking, 0);
        }

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int matchWinningNumber = getWinningNumberScore(numbers, winningNumbers);
            boolean matchBonusNumber = getBonusNumberScore(numbers, bonusNumber);

            winningList.put(LottoRanking.getRanking(matchWinningNumber, matchBonusNumber), winningList.get(LottoRanking.getRanking(matchWinningNumber, matchBonusNumber)) + 1);
        }
        return winningList;
    }

    public boolean getBonusNumberScore(List<Integer> numbers, BonusNumber bonusNumber) {
        boolean matchBonusNumber = false;
        if (numbers.contains(bonusNumber)) {
            matchBonusNumber = true;
        }
        return matchBonusNumber;
    }

    public int getWinningNumberScore(List<Integer> numbers, WinningNumbers winningNumbers) {
        int matchWinningNumber = 0;
        for (int i = 0; i < winningNumbers.getWinningNumbers().size(); i++) {
            List<Integer> winningNumber = winningNumbers.getWinningNumbers();
            if (numbers.contains(winningNumber.get(i))) {
                matchWinningNumber++;
            }
        }
        return matchWinningNumber;
    }

    public void printWinningList(HashMap<LottoRanking, Integer> winningList) {
        for (int i = 5; i >= 1; i--) {
            System.out.printf("%s - %d개\n",
                    LottoRanking.findByRanking(i).getMessage(),
                    winningList.get(LottoRanking.findByRanking(i)));
        }
    }



}
