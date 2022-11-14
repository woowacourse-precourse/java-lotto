package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoString;
import lotto.WinningStatus;
import lotto.domain.Lotto;
import lotto.dto.LottoAndUserNumberDto;
import lotto.dto.LottoMatchDto;
import lotto.dto.MatchStatusDto;
import lotto.global.ErrorMessage;
import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class LottoService {

    public List<Integer> makeRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int validePrice(String price) {
        IntStream.range(0, price.length()).filter(
                i -> !Character.isDigit(price.charAt(i))).forEach(i -> {
            throw new IllegalArgumentException(ErrorMessage.UNMATCH_PRICE_UNIT);
        });

        int priceInt = Integer.parseInt(price);
        if(priceInt % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.UNMATCH_PRICE_UNIT);
        }
        return priceInt;
    }

    public List<Integer> validateUserInput(String userInput) {
        StringTokenizer stringTokenizer = new StringTokenizer(userInput, ",");
        List<Integer> numbers = new ArrayList<>();

        while(stringTokenizer.hasMoreTokens()){
            String nextToken = stringTokenizer.nextToken();
            Integer number = isLottoNumber(nextToken);
            numbers.add(number);
        }
        if(numbers.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_INPUT_ERROR);
        }

        return numbers;
    }

    private Integer isLottoNumber(String number){
        boolean isNumber = number.chars().allMatch(Character::isDigit);
        if(isNumber == false){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_INPUT_ERROR);
        }
        int intNumber = Integer.parseInt(number);
        if(intNumber < 1 || intNumber > 45){
            throw new IllegalArgumentException(ErrorMessage.NUMBER_INPUT_ERROR);
        }
        return intNumber;
    }

    public Integer validateBonusNumber(String userInput) throws Exception {
        try {
            Integer bonusNumber = isLottoNumber(userInput);
            return bonusNumber;
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_ERROR);
        }catch(Exception e){
            throw new Exception(ErrorMessage.SERVER_INTERNAL_ERROR);
        }
    }

    public LottoMatchDto getStatistic(LottoAndUserNumberDto lottoAndUserNumberDto) {
        List<Lotto> guessNumberSet = lottoAndUserNumberDto.getGuessNumberSet();
        List<Integer> lottoNumber = lottoAndUserNumberDto.getLottoNumber();
        Integer bonusNumber = lottoAndUserNumberDto.getBonusNumber();
        Integer purchaseCost = lottoAndUserNumberDto.getPurchaseCost();

        Double income = 0d;
        Integer[] matchCount = {0,0,0,0,0,0};

        for (Lotto lotto : guessNumberSet) {
            MatchStatusDto matchStatusDto = makeMatchDto(lottoNumber, bonusNumber, lotto);
            income += matchStatusDto.getIncome();
            matchCount[matchStatusDto.getGrade()]++;
        }
        List<Integer> matchCountList = new ArrayList<>(List.of(matchCount));
        return new LottoMatchDto(income / (double)purchaseCost, matchCountList);
    }

    private MatchStatusDto makeMatchDto(List<Integer> lottoNumber, Integer bonusNumber, Lotto lotto) {
        Double income = 0d;

        WinningStatus winningStatus = judgeLottoStatus(lotto, lottoNumber, bonusNumber);
        income += winningStatus.getPrice();

        return new MatchStatusDto(income, winningStatus.getGrade());
    }

    private WinningStatus judgeLottoStatus(Lotto lotto, List<Integer> lottoNumber, Integer bonusNumber){
        List<Integer> guessNumbers = lotto.getNumbers();

        int statusCount = 0;
        boolean getBonus = false;
        for (Integer guessNumber : guessNumbers) {
            if(lottoNumber.contains(guessNumber)){
                statusCount++;
            }
        }

        if(guessNumbers.contains(bonusNumber)){
            getBonus = true;
        }

        return getWinningStatus(statusCount, getBonus);
    }

    private WinningStatus getWinningStatus(int statusCount, boolean getBonus) {
        if(statusCount == 6){
            return WinningStatus.MATCH_SIX;
        }else if(statusCount == 5 && getBonus){
            return WinningStatus.MATCH_FIVE_BONUS;
        }else if(statusCount == 5){
            return WinningStatus.MATCH_FIVE;
        }else if(statusCount == 4){
            return WinningStatus.MATCH_FOUR;
        }else if(statusCount == 3){
            return WinningStatus.MATCH_THREE;
        }
        return WinningStatus.NOTHING;
    }
}
