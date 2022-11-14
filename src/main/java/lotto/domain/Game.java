package lotto.domain;

import lotto.constant.Constant;
import lotto.constant.Message;
import lotto.util.WinningInfo;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private User user;
    private Service service;
    private int[] winningResult;
    private int winningPrize;
    private double profitRate;

    public Game(){
        user = new User();
        int nLottoTickets = user.getnLottoTickets();

        service = new Service(nLottoTickets);

        winningResult = new int[Constant.RANK_SIZE];
        winningPrize = 0;
        profitRate = 0.0;
    }

    public void runGame(){
        Message.printStartWinningStatistics();

        // 사용자 로또 순환 하면서 1. 일치 개수 얻기, 2. 등수 얻기, 3. 해당 등수 없으면 continue, 있으면 결과 추가
        List<Lotto> lottoTickets = service.getLottoTickets();
        for (int i=0; i < lottoTickets.size(); i++){

            Lotto lottoTicket = lottoTickets.get(i);
            List<Integer> lottoNumbers = lottoTicket.getNumbers();

            //1. 일치 개수 얻기
            int sameCount = getSameCount(lottoNumbers);

            //2. 등수 얻기
            int rank = getRank(sameCount, lottoNumbers);

            //3. 해당 등수 없으면 continue, 있으면 결과 추가
            if (isNotRank(rank)){
                continue;
            }
            
            setWinningResult(rank);
        }

        setWinningPrize();
        // TODO: 사용자의 당첨 통계(당첨 개수) 출력

        setProfitRate();
        // TODO: 사용자의 수익률 출력
    }

    private void setWinningResult(int rank) {
        this.winningResult[rank - 1] += 1;
    }

    private void setWinningPrize() {
        for (int i=0; i< WinningInfo.values().length; i++){
            this.winningPrize += WinningInfo.values()[i].getPrize() * this.winningResult[i];
        }
    }

    private void setProfitRate() {
        this.profitRate = ((double) this.winningPrize / user.getLottoMoney()) * 100;
    }

    private boolean isNotRank(int rank) {
        return rank == -1;
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

            if (sameCount == 5){
                return checkBonusNumberRank(lottoNumbers);
            }

            if (sameCount == WinningInfo.values()[i].getSameCount()){
                return WinningInfo.values()[i].getRank();
            }
        }

        return -1;
    }

    private int checkBonusNumberRank(List<Integer> lottoNumbers) {

        if(lottoNumbers.contains(service.getBonusNumber())){
            return 2;
        }

        return 3;
    }
}
