package lotto.controller;

import lotto.domain.User;
import lotto.domain.ValidUserInput;
import lotto.service.UserBonusNumberService;
import lotto.service.UserLottoNumberService;
import lotto.service.UserMoneyService;
import lotto.utils.OutputEnumMessage;
import lotto.utils.OutputNonEnumMessage;

import java.util.*;

public class LotteryDraw {

    UserLottoNumberService userLottoNumber = new UserLottoNumberService();
    UserMoneyService userMoney = new UserMoneyService();
    UserBonusNumberService userBonusNumber = new UserBonusNumberService();

    private static final int MIN_WIN_NUMBER = 3; // 당첨 최소 갯수
    private static final int MAX_WIN_NUMBER = 6;
    private static final int BONUS_BALL = 7;
    private static final int WIN_BONUS_BALL = 1;
    private static final int LOSE_BONUS_BALL = 0;

    public void drawLottery(){ // 로또 갯수 만큼 로또 만들기
        LottoService lottoService = new LottoService();
        UserService userService = new UserService();

        List<List<Integer>> autoCreateLottoNumbers = lottoService.LottoComp();
        List<Integer> userLottoNumber = userService.getLottoNumber();
        List<Integer> winLotteryNumber = new ArrayList<>(Collections.emptyList()); // 5개

        int bonusNumber = userService.getBonusNumber();
        ValidUserInput.isBonusNumberNotSameRandomNumber(bonusNumber,userLottoNumber);

        for(List<Integer> autoLotto : autoCreateLottoNumbers){
            int winNumberCount = getWinNumberCount(autoLotto,userLottoNumber);
            if(winNumberCount > MIN_WIN_NUMBER){
                winLotteryNumber.add(winNumberCount);
            }
        }//보너스 볼이랑 로또 번호랑 같은지도 체크
        int bonusCount = bonusNumberCheck(bonusNumber, winLotteryNumber);
        printResult(winLotteryNumber, bonusCount);
    }

    private int getWinNumberCount(List<Integer> autoNumber, List<Integer> inputNumber){
        int count = 0;

        for(int i : inputNumber){ // 숫자가 포함되어 있으면 count+1;
            if(autoNumber.contains(inputNumber.get(i))){
                count++;
            }
        }
        return count;
    }

    private int bonusNumberCheck(int bonusNumber, List<Integer> winLotteryNumber) {
        if(winLotteryNumber.contains(bonusNumber)){
            return WIN_BONUS_BALL;
        }
        return LOSE_BONUS_BALL;
    }

    private void printResult(List<Integer> winLotteryNumber, int bonusNumber) {
        OutputEnumMessage outputMessage;
        System.out.println(OutputNonEnumMessage.WIN_A_LOTTERY_STATUS);
        System.out.println(OutputNonEnumMessage.SEPARATION);

        Map<OutputEnumMessage, Integer> winCount = new EnumMap<>(OutputEnumMessage.class);

        //3 == 당첨 최소 개수 6 == 당첨 최대 개수
        for(int i = MIN_WIN_NUMBER; i <= MAX_WIN_NUMBER; i++) { // 해쉬맵에 각 맞은 숫자의 갯수를 정함
            winCount.put(i, Collections.frequency(winLotteryNumber, i));
        }

        winCount.put(BONUS_BALL, bonusNumber); // 7 == 보너스볼 KEY

        //enum돌면서 3부터 wincount.get(i)
        for(int key : winCount.keySet()){ //int로 바꿔야 enum이랑 같이 출력가능
            int value = winCount.get(key);
            System.out.println(); // enum 갯수 문장 + value
        }

        getLottoEarningRatio(winCount);
    }

    private void getLottoEarningRatio(Map<Integer, Integer> winCount) {
        User userMoney = new User();

    }

    private Map<OutputEnumMessage, Integer> getWinCount(List<Integer> winLotteryNumber){
        for(int i = MIN_WIN_NUMBER; i <= MAX_WIN_NUMBER; i++){
            System.out.println(i + "개 일치");
        }
    }
}
