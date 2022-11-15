package lotto.domain;

import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.domain.model.Lotto;
import lotto.util.WinningInfo;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final User user;
    private final Service service;
    private int[] winningResult;
    private int winningPrize;
    private double profitRate;

    public Game(){
        user = new User();
        int nLottoTickets = user.getnLottoTickets();

        service = new Service(nLottoTickets);

        winningResult = new int[Constant.RANK_SIZE];
        winningPrize = Constant.ZERO_WINNING_PRIZE;
        profitRate = Constant.ZERO_PROFIT_RATE;
    }

    public void runGame(){
        Message.printStartWinningStatistics();
        setWinningResult();

        setWinningPrize();
        Message.printWinningStatistics(this.winningResult);

        setProfitRate();
        Message.printProfitRate(this.profitRate);
    }

    // 사용자 로또 순환 하면서 1. 일치 개수 얻기, 2. 등수 얻기, 3. 해당 등수 없으면 continue, 있으면 결과 추가
    private void setWinningResult(){
        List<Lotto> lottoTickets = service.getLottoTickets();
        for (int i=0; i < lottoTickets.size(); i++){

            List<Integer> lottoNumbers = lottoTickets.get(i).getNumbers();

            int sameCount = getSameCount(lottoNumbers);
            int rank = getRank(sameCount, lottoNumbers);

            if (isNotRank(rank)){
                continue;
            }

            setResult(rank);
        }
    }

    private void setResult(int rank) {
        this.winningResult[rank - 1] += 1;
    }

    private void setWinningPrize() {
        for (int i=0; i< WinningInfo.values().length; i++){
            this.winningPrize += WinningInfo.values()[i].getPrize() * this.winningResult[i];
        }
    }

    private void setProfitRate() {
        if (isWinningPrizeZero()) {
            this.profitRate = Constant.ZERO_PROFIT_RATE;
            return;
        }

        this.profitRate = ((double) this.winningPrize / user.getUserMoney()) * 100;
    }

    private boolean isWinningPrizeZero(){
        return this.winningPrize == Constant.ZERO_WINNING_PRIZE;
    }
    private boolean isNotRank(int rank) {
        return rank == Constant.NO_RANK;
    }

    private int getSameCount(List<Integer> lottoNumbers){
        List<Integer> equalLottoNumbers = new ArrayList<>(lottoNumbers);
        equalLottoNumbers.retainAll(service.getWinningNumbers());

        if (equalLottoNumbers.isEmpty()){
            return 0;
        }

        return equalLottoNumbers.size();
    }

    private int getRank(int sameCount, List<Integer> lottoNumbers) {
        for (int i=0; i< WinningInfo.values().length; i++){

            if (sameCount == Constant.CHECK_BONUS_COUNT){
                return checkBonusNumberRank(lottoNumbers);
            }

            if (sameCount == WinningInfo.values()[i].getSameCount()){
                return WinningInfo.values()[i].getRank();
            }
        }

        return Constant.NO_RANK;
    }

    private int checkBonusNumberRank(List<Integer> lottoNumbers) {
        if(lottoNumbers.contains(service.getBonusNumber())){
            return WinningInfo.SECONDRANK.getRank();
        }

        return WinningInfo.THIRDRANK.getRank();
    }
}
