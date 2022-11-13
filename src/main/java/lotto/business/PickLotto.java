package lotto.business;

import lotto.setting.Setting;
import lotto.ui.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PickLotto {

    public List<Integer> lottoNumbers(){
        String inputLottoNumber = inputLottoNumber().replaceAll(" ", "");
        validateInputLottoNumber(inputLottoNumber);

        return Arrays.stream(inputLottoNumber.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    public int bonusNumber(){
        String inputBonusNumber = inputBonusNumber();
        validateBonusNumberIsRightNumber(inputBonusNumber);

        return Integer.parseInt(inputBonusNumber);
    }

    private String inputLottoNumber(){
        Output.printInputWinningNumber();
        return readLine();
    }

    private void validateInputLottoNumber(String inputLottoNumber){
        validateInputLottoNumberIsTotal(inputLottoNumber);
        validateInputLottoNumberIsRightSeparator(inputLottoNumber);
    }

    private void validateInputLottoNumberIsTotal(String inputLottoNumber){
        if(inputLottoNumber.split(",").length != Setting.LOTTO_PICK_NUMBER){
            throw new IllegalArgumentException("[ERROR] "+Setting.LOTTO_PICK_NUMBER+"개의 로또 번호를 입력해야합니다.");
        }
    }

    private void validateInputLottoNumberIsRightSeparator(String inputLottoNumber){
        for(String number : inputLottoNumber.split(",")){
            try{
                validateInputNumberIsBetween(Integer.parseInt(number));
            }catch (Exception e){
                throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분된 숫자를 입력해야합니다.");
            }
        }
    }

    private void validateInputNumberIsBetween(int number){
        if(number < Setting.LOTTO_MIN_NUMBER && number > Setting.LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 번호는 "+Setting.LOTTO_MIN_NUMBER+"부터 "+ Setting.LOTTO_MAX_NUMBER +" 사이의 숫자여야 합니다.");
        }
    }

    private String inputBonusNumber(){
        Output.printBonusNumber();
        return readLine();
    }

    private void validateBonusNumberIsRightNumber(String input){
        try{
            validateInputNumberIsBetween(Integer.parseInt(input));
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 하나의 숫자를 입력해야합니다.");
        }
    }




}
