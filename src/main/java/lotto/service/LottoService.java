package lotto.service;

import lotto.Enum.LottoInfo;
import lotto.Enum.WinningPrice;
import lotto.Enum.WinningType;
import lotto.entity.GeneratedLottos;
import lotto.entity.Lotto;
import lotto.entity.User;
import lotto.utils.Parser;
import lotto.utils.RandomUtils;
import lotto.utils.Validation;
import lotto.view.SystemMessage;
import lotto.view.UserRequest;

import java.lang.reflect.WildcardType;
import java.util.*;


public class LottoService {

    Lotto lotto;
    GeneratedLottos generatedLottos = new GeneratedLottos();
    User user = new User();


    public void getPurchaseMoney() {
        String input = UserRequest.userInput();
        if (Validation.validatePurchaseAmount(input)) {
            user.setPurchaseMoney(Parser.StringToInt(input));
        }
    }
    public void getLottoCount() {
        user.setLottoAmount(Parser.countLotto(user.getPurchaseMoney()));
    }

    public void getRandomLottos() {
        int lottoCount = user.getLottoAmount();
        generatedLottos.setAllLottos(generateLottos(lottoCount));
    }

    public List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> allLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            allLottos.add(new Lotto(
                    RandomUtils.getRandomLottoNumber(
                            LottoInfo.START.getInfo(),
                            LottoInfo.END.getInfo(),
                            LottoInfo.COUNT.getInfo())));
        }
        return allLottos;
    }
    public void getUserNumber() {
        String input = UserRequest.userInput();
        user.setUserNumber(Parser.seperateCommas(input));
    }

    public void getBounsNumber() {
        String input = UserRequest.userInput();
        Validation.validateBonusNumber(input,user.getUserNumber());
        user.setBonusNumber(Parser.StringToInt(input));
    }

    public void getWinningHistory() {
        List<Integer> userNumber = user.getUserNumber();
        int bonusNumber = user.getBonusNumber();
        List<Lotto> lottoNumbers = generatedLottos.getAllLottos();

    }
    // Refactoring need
    public void matchWinning(List<Lotto> lottoNumbers, List<Integer> userNumber, int bonusNumber) {
        HashMap<Integer,Integer> winningHistory = user.getWinning();

        for (Lotto lottoNumber : lottoNumbers) {
            List<Integer> lotto = lottoNumber.getNumbers();
            int accordance = getAccordance(lotto, userNumber);
            boolean bonus = matchBonusNumber(lotto, bonusNumber);
            int rank = getRank(accordance, bonus);
            winningHistory.put(rank, winningHistory.get(rank) + 1);
        }

        printWinningHistory(winningHistory);
        user.setWinning(winningHistory);
    }

    public int getAccordance(List<Integer> lottoNumber, List<Integer> userNumber) {
        int result = 0;
        for (Integer number : lottoNumber) {if (userNumber.contains(number)) {result++;}}
        return result;
    }

    public boolean matchBonusNumber(List<Integer> lottoNumber, int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    public int getRank(int accordance, boolean Bonus) {
        if (Bonus && accordance == 5) { return 5; }
        if (accordance == 6) { return 1; }
        return (8 - accordance);
    }

    public static void printWinningHistory(HashMap<Integer, Integer> winningHistory) {
        for (Map.Entry<Integer,Integer> entry: winningHistory.entrySet()) {
            SystemMessage.printWinningHistory(entry.getKey(), entry.getValue());
        }
    }

    public void getYeild() {
        int purchaseAmount = user.getPurchaseMoney();
        int winningAmount = 0;

        List<Integer> rankPrice = new ArrayList<>();
        for (WinningPrice winningPrice : WinningPrice.values()) {
            rankPrice.add(winningPrice.getPrice());
        }
        List<Integer> rankCount = new ArrayList<>(user.getWinning().values());

        for (int i = 0; i < rankPrice.size(); i++) {
            winningAmount += rankPrice.get(i) * rankCount.get(i);
        }

        user.setYield((long) (winningAmount / purchaseAmount));

    }
}
