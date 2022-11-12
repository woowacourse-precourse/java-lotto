package lottoService;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import common.Constant;
import common.LottoGameMessage;
import domain.Lotto;
import domain.LottoRank;
import domain.LottoReward;
import domain.Player;

import java.util.*;

public class LottoService {

    LottoGameMessage lottoGameMessage = new LottoGameMessage();


    public void inputPurchasePriceAndCheckException(Player player){
        lottoGameMessage.printPurchasePriceMessage();
        String purchaseLottoPrice = input();
        isNumber(purchaseLottoPrice);
        player.inputPurchaseLottoPrice(Integer.parseInt(purchaseLottoPrice));
        player.canDivideThousand();
        player.countLottoNumber();
    }

    public Lotto inputWinningLottoNumber(){
        lottoGameMessage.printWinningNumberMessage();
        return new Lotto(inputLottoWinningNumbers());
    }

    public Integer inputBonusNumber(Lotto winningLotto){
        lottoGameMessage.printBonusNumberMessage();
        return inputLottoBonusNumber(winningLotto);
    }

    public void checkWinningNumberAndBonusNumber(Lotto winningLotto){
        isDuplicate(winningLotto.getNumbers());
        isValidRange(winningLotto.getNumbers());
    }

    public void comparePlayerLottoNumberAndWinningLottoNumberLogic(Player player , Lotto winningLotto , Integer lottoBonusNumber){
        List<Integer> lottoWinningNumbers = winningLotto.getNumbers();
        Iterator<Lotto> playerLottoNumberIterator = player.getPlayerLottoPickNumbers().iterator();

        while (playerLottoNumberIterator.hasNext()){
            initializePlayerLottoCount(player);
            Lotto playerRandomLottoNumbers = playerLottoNumberIterator.next();

            comparePlayerLottoNumberAndWinningLottoNumber(lottoWinningNumbers,playerRandomLottoNumbers,player,lottoBonusNumber);
            saveLottoResult(player);
        }
    }

    public void comparePlayerLottoNumberAndWinningLottoNumber(List<Integer> lottoWinningNumbers , Lotto playerRandomLottoNumbers , Player player , Integer lottoBonusNumber){
        for (Integer lottoWinningNumber : lottoWinningNumbers) {
            if(playerRandomLottoNumbers.getNumbers().contains(lottoWinningNumber))
                player.addLottoCount();
        }
        if(playerRandomLottoNumbers.getNumbers().contains(lottoBonusNumber))
            player.bonusNumberIncludedWinningLottoNumber();
    }

    public void saveLottoResult(Player player){
        if(player.getIsWinningLottoNumberBonusNumber())
            player.minusLottoCount();

        if(LottoRank.WIN_LOTTO_3.getCount() == player.getLottoCount())
            player.getWinningLottoCount().put(LottoRank.WIN_LOTTO_3 , player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_3,0) + 1);

        if(LottoRank.WIN_LOTTO_4.getCount() == player.getLottoCount())
            player.getWinningLottoCount().put(LottoRank.WIN_LOTTO_4 , player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_4,0) + 1);

        if(LottoRank.WIN_LOTTO_5_BONUS.getCount() == player.getLottoCount() && player.getIsWinningLottoNumberBonusNumber())
            player.getWinningLottoCount().put(LottoRank.WIN_LOTTO_5_BONUS , player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_5_BONUS,0) + 1);

        if(LottoRank.WIN_LOTTO_5.getCount() == player.getLottoCount())
            player.getWinningLottoCount().put(LottoRank.WIN_LOTTO_5 , player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_5,0) + 1);

        if(LottoRank.WIN_LOTTO_6.getCount() == player.getLottoCount())
            player.getWinningLottoCount().put(LottoRank.WIN_LOTTO_6 , player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_6,0) + 1);
    }

    public void lookForPlayerLottoRevenue(Player player){
        int countWinningLottoThree = player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_3,0);
        int countWinningLottoFour = player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_4,0);
        int countWinningLottoFive = player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_5,0);
        int countWinningLottoFiveAndBonus = player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_5_BONUS,0);
        int countWinningLottoSix = player.getWinningLottoCount().getOrDefault(LottoRank.WIN_LOTTO_6,0);

        player.addLottoRevenue(countWinningLottoThree * LottoReward.REWARD_LOTTO_3.getReward());
        player.addLottoRevenue(countWinningLottoFour * LottoReward.REWARD_LOTTO_4.getReward());
        player.addLottoRevenue(countWinningLottoFive * LottoReward.REWARD_LOTTO_5.getReward());
        player.addLottoRevenue(countWinningLottoFiveAndBonus * LottoReward.REWARD_LOTTO_5_BONUS.getReward());
        player.addLottoRevenue(countWinningLottoSix * LottoReward.REWARD_LOTTO_6.getReward());
    }

    public void printPlayerLottoResult(Player player){
        lottoGameMessage.printLottoWinningStatistics(player);
        lottoGameMessage.printPlayerLottoYield(player);
    }

    public void initializePlayerLottoCount(Player player){
        player.initializeLottoCount();
    }

    public List<Integer> inputLottoWinningNumbers(){
        List<Integer> lottoWinningNumbers = new ArrayList<>();
        String inputLottoPickNumbers = input().trim().replaceAll(" ","");
        hasSixLottoNumber(inputLottoPickNumbers);

        String[] lottoPickNumbers = inputLottoPickNumbers.split(",");
        for (String winningNumber : lottoPickNumbers) {
            isNumber(winningNumber);
            lottoWinningNumbers.add(Integer.parseInt(winningNumber));
        }
        Collections.sort(lottoWinningNumbers);
        return lottoWinningNumbers;
    }

    public Integer inputLottoBonusNumber(Lotto lotto){
        String lottoBonusNumber = input();
        int bonusNumber = Integer.parseInt(lottoBonusNumber);
        lotto.getNumbers().add(bonusNumber);
        return bonusNumber;
    }

    public void isDuplicate(List<Integer> winningLottoNumbers){
        Set<Integer> checkDuplicateNumber = new HashSet<>();
9
        for (Integer winningLottoNumber : winningLottoNumbers) {
            if(checkDuplicateNumber.contains(winningLottoNumber))
                throw new IllegalArgumentException(Constant.EXIST_DUPLICATE_NUMBER_EXCEPTION);

            checkDuplicateNumber.add(winningLottoNumber);
        }
    }

    public void hasSixLottoNumber(String inputPlayerLottoPickNumbers){
        if(inputPlayerLottoPickNumbers.split(",").length != 6)
            throw new IllegalArgumentException(Constant.NOT_MATCH_PICK_NUMBER_EXCEPTION);
    }

    public void isValidRange(List<Integer> winningLottoNumbers){
        for (Integer number : winningLottoNumbers) {
            if(Constant.LOTTO_START_NUMBER > number || Constant.LOTTO_END_NUMBER < number)
                throw new IllegalArgumentException(Constant.NOT_VALID_RANGE_EXCEPTION);
        }
    }

    public void printPlayerLottoNumberAndCreateLottoNumber(Player player){
        lottoGameMessage.printPurchaseCountMessage(player.getLottoCount());
        createPlayerRandomLottoPickNumbers(player);
        lottoGameMessage.printPlayerRandomLottoPickNumbers(player);
    }

    public void isNumber(String number){
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(Constant.NOT_NUMBER_EXCEPTION);
        }
    }

    public void createPlayerRandomLottoPickNumbers(Player player){
        for (int lottoNum = 0; lottoNum < player.getLottoCount(); lottoNum++) {
            Lotto playerLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(playerLotto.getNumbers());
            player.getPlayerLottoPickNumbers().add(playerLotto);
        }
    }

    private String input(){
        return Console.readLine().trim().replaceAll(" ","");
    }
}
