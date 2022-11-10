package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.User.*;

public class NumberGenerator {

    public List<Integer> makeNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    public List<Integer> readLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNumber = readLine();
        validDataInputLottoNumber(inputLottoNumber);
        return convertLottoNumber(inputLottoNumber);
    }

    public int readBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = readLine();
        validDataBonusNumber(bonus);
        return Integer.parseInt(bonus);
    }

    public int validDataBonusNumber(String bonus) {
        // 포맷이 잘못된 경우 or 범위가 초과하는 경우
        int bonusNum = 0;
        try{
            bonusNum = Integer.parseInt(bonus);
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 보너스 번호 입력이 잘못 되었습니다.");
            throw new IllegalArgumentException();
        }

        if(bonusNum > LOTTO_MAX_SIZE || bonusNum < LOTTO_MIN_SIZE){
            System.out.println("[ERROR] 숫자는 1이상 45 이하의 숫자로 구성되어야 합니다.");
            throw new IllegalArgumentException();
        }
        return bonusNum;
    }

    public List<Integer> convertLottoNumber(String inputLottoNumber) {
        ArrayList<String> split = new ArrayList<>(List.of(inputLottoNumber.split(", ")));
        return split.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public void validDataInputLottoNumber(String inputLottoNumber) {
        ArrayList<String> split = new ArrayList<>(List.of(inputLottoNumber.split(", ")));
        unValidShape(split);

        List<Integer> lottoNumber = convertLottoNumber(inputLottoNumber);
        duplicatedNumber(lottoNumber);
        checkNumberArea(lottoNumber);
    }

    public void unValidShape(ArrayList<String> lottoNumber){
        if(lottoNumber.size() != LOTTO_LEN){
            System.out.println("[ERROR] 숫자 입력이 잘못 되었습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void duplicatedNumber(List<Integer> lottoNumber) {
        List<Integer> collect = lottoNumber.stream().distinct().collect(Collectors.toList());
        if(collect.size() != LOTTO_LEN){
            System.out.println("[ERROR] 중복된 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }

    }

    public void checkNumberArea(List<Integer> lottoNumber){
        for (Integer integer : lottoNumber) {
            if(integer > LOTTO_MAX_SIZE || integer < LOTTO_MIN_SIZE){
                System.out.println("[ERROR] 숫자는 1이상 45 이하의 숫자로 구성되어야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

}
