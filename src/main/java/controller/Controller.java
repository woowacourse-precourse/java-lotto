package controller;

import lotto.Lotto;
import model.Server;
import view.Client;
import view.PrintResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Controller {
    private final Client client = new Client();
    private final Server server = new Server();
    private HashMap<Integer, Integer> matchNumberCount = new HashMap<>();

    public void checkLotto() {
        int money = setMoney();
        if(money == 0) {
            return;
        }
        List<Integer> winLottoNumber = client.getWinLottoNumber();
        new Lotto(winLottoNumber);
        int bonusNumber = setBonusNumber(winLottoNumber);
        int lottoPaper = server.decideToBuyLotto(money);
        setMatchNumberCount();
        PrintResult.printBuyLotto(lottoPaper);
        lottoCompareAndSave(lottoPaper, winLottoNumber, bonusNumber);
        PrintResult.printMatchDetail(matchNumberCount);
        int totalMoney = server.moneyToLotto(matchNumberCount);
        PrintResult.printRevenue(totalMoney, money);
    }

    public void setMatchNumberCount() {
        for(int match = 3; match < 8; match++){
            matchNumberCount.put(match, 0);
        }
    }

    public void putMatchNumberCount(int matchNumber) {
        matchNumberCount.put(matchNumber, matchNumberCount.get(matchNumber) + 1);
    }

    private int setMoney(){
        int money = 0;
        try {
            money = client.getLottoMoney();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 올바른 값을 입력하세요.");
            return 0;
        }
        return money;
    }

    private int setBonusNumber(List<Integer> winLottoNumber){
        int bonusNumber = 0;
        do {
            bonusNumber = client.getWinBonusNumber();
        } while (server.isInclude(winLottoNumber, bonusNumber));
        return bonusNumber;
    }

    private Boolean isMatchNumberUnderThree(int matchNumber){
        return matchNumber < 3;
    }

    private int matchNumberNeedBonusNumber(int matchNumber, List<Integer> lottoNumber, int bonusNumber){
        if(matchNumber == 5 && server.compareBonusNumber(lottoNumber, bonusNumber)){
            matchNumber = 7;
        }
        return matchNumber;
    }

    private List<Integer> setLottoNumber(){
        List<Integer> lottoNumber = new ArrayList<>(server.publishLotto());
        new Lotto(lottoNumber);
        PrintResult.printLottoNumber(lottoNumber);
        return lottoNumber;
    }

    private void lottoCompareAndSave(int lottoPaper, List<Integer> winLottoNumber, int bonusNumber){
        for (int lotto = 0; lotto < lottoPaper; lotto++) {
            List<Integer> lottoNumber = setLottoNumber();
            Set common = server.compareLottoNumber(lottoNumber, winLottoNumber);
            int matchNumber = server.countMatchNumber(common);
            if(isMatchNumberUnderThree(matchNumber)){
                continue;
            }
            matchNumber = matchNumberNeedBonusNumber(matchNumber, lottoNumber, bonusNumber);
            putMatchNumberCount(matchNumber);
        }
    }
}
