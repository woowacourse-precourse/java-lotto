package lotto.domain.winningLotto;

import lotto.exception.LottoException;
import lotto.setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class ValidateWinningLotto {

    public void validateInputLottoNumber(String inputLottoNumber){
        validateInputLottoNumberIsTotal(inputLottoNumber);
        validateInputLottoNumberIsRightSeparator(inputLottoNumber);
        validateInputNumberHaveSame(inputLottoNumber);
    }

    private void validateInputLottoNumberIsTotal(String inputLottoNumber){
        if(inputLottoNumber.split(",").length != Setting.LOTTO_PICK_NUMBER){
            throw new LottoException(Setting.LOTTO_PICK_NUMBER+"개의 로또 번호를 입력해야합니다.");
        }
    }

    private void validateInputLottoNumberIsRightSeparator(String inputLottoNumber){
        for(String number : inputLottoNumber.split(",")){
            try{
                validateInputNumberIsBetween(Integer.parseInt(number));
            }catch (Exception e){
                throw new LottoException("쉼표(,)로 구분된 숫자를 입력해야합니다.");
            }
        }
    }

    private void validateInputNumberIsBetween(int number){
        if(number < Setting.LOTTO_MIN_NUMBER || number > Setting.LOTTO_MAX_NUMBER){
            throw new LottoException("번호는 "+Setting.LOTTO_MIN_NUMBER+"부터 "+ Setting.LOTTO_MAX_NUMBER +" 사이의 숫자여야 합니다.");
        }
    }

    private void validateInputNumberHaveSame(String inputLottoNumbe){
        List<String> tmp = new ArrayList<>();
        for(String number : inputLottoNumbe.split(",")){
            if(tmp.contains(number)) {
                throw new LottoException("중복된 숫자는 사용할 수 없습니다.");
            }
            else {
                tmp.add(number);
            }
        }
    }

    public void validateBonusNumberIsRightNumber(String input){
        try{
            validateInputNumberIsBetween(Integer.parseInt(input));
        }catch (Exception e){
            throw new LottoException("하나의 숫자를 입력해야합니다.");
        }
    }
}
