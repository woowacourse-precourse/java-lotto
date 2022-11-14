package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constants.Constants.*;

public class UserIOService {

    public int scanPayMoney() {
        System.out.println(START_MSG);
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    public void validateMoney(int money) {
        if (money % LOTTO_PRICE == 0) return;
        throw new IllegalArgumentException(PAY_MONEY_ERROR);
    }


    public String printIssuedLotto(int purchaseLottoNum, List<Lotto> purchaseLotto) {
        StringBuilder printString = new StringBuilder();
        printString.append(BLANK_BR); //한줄 공백
        printString.append(purchaseLottoNum).append(PURCHASE_MSG).append("\n");
        for(Lotto now : purchaseLotto){
            printString.append(now).append("\n");
        }
        return printString.toString();
    }

    public List<Integer> scanWinningNumber(){
        System.out.println(SCAN_ANSWER_MSG);
        List<Integer> scanNumbers = Arrays.stream(Console.readLine().split(","))
            .mapToInt(Integer::valueOf).sorted().boxed().collect(Collectors.toList());
        validateAnswer(scanNumbers);
        return scanNumbers;
    }

    private void validateAnswer(List<Integer> scanNumbers) {
        checkRange(scanNumbers);
        checkSize(scanNumbers);
        checkDuplicate(scanNumbers);
    }

    private void checkDuplicate(List<Integer> scanNumbers) {
        List<Integer> distinctNumbers = new ArrayList<>();
        for(int num:scanNumbers){
            if(distinctNumbers.contains(num))
                throw new IllegalArgumentException(ANSWER_DUPLICATE_ERROR);
            distinctNumbers.add(num);
        }
    }

    private void checkRange(List<Integer> scanNumbers) {
        for(int num:scanNumbers){
            if(num<LOTTO_RANGE_START || LOTTO_RANGE_END<num)
                throw new IllegalArgumentException(ANSWER_RANGE_ERROR);
        }
    }

    private void checkSize(List<Integer> scanNumbers) {
        if(scanNumbers.size()==LOTTO_NUMS_SIZE) return;

        if(scanNumbers.size()<LOTTO_NUMS_SIZE)
            throw new IllegalArgumentException(ANSWER_COUNT_LOWER_ERROR);

        throw new IllegalArgumentException(ANSWER_COUNT_OVER_ERROR);
    }

    public int scanBonusNumber(List<Integer> lottoNumbers){
        System.out.println(BLANK_BR+SCAN_BONUS_NUMBER_MSG);
        int bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber(bonusNumber,lottoNumbers);
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        checkRange(List.of(bonusNumber));
        //checkBonusSize(bonusNumber);
        checkBounsDuplicate(bonusNumber,lottoNumbers);
    }

    private void checkBounsDuplicate(int bonusNumber, List<Integer> lottoNumbers) {
        if(lottoNumbers.contains(bonusNumber))
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR);
    }

//    private void checkBonusSize(int bonusNumber) {
//        if(bonusNumber)
//    }


}
