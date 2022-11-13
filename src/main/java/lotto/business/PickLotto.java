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
                validateInputLottoNumberIsBetween(Integer.parseInt(number));
            }catch (Exception e){
                throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분된 숫자를 입력해야합니다.");
            }
        }
    }

    private void validateInputLottoNumberIsBetween(int number){
        if(number < Setting.LOTTO_MIN_NUMBER && number > Setting.LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }




}
