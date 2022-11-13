package lotto.service;

import lotto.domain.User;
import lotto.domain.ValidUserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottoNumberService {
    private static final String[] lottoNumber = User.getUserInputLottoNumber();

    public List<Integer> getLottoNumber(){
        List<Integer> lottoNumbers = new ArrayList<>(Collections.emptyList());

        for (String number : lottoNumber) {
            lottoNumbers.add(Integer.parseInt(number)); //통과했다면 List<>에 넣어줌
        }
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public UserLottoNumberService() {
        ValidInputNumberSize(lottoNumber);
        for (String number : lottoNumber) { // 입력받은 로또 번호 검증
            ValidUserInput.ValidInputNumberInteger(number);
            ValidUserInput.ValidInputNumberOverZero(number);
            ValidInputNumberOverZero(number);
            ValidInputNumberRange(number);
        }
    }

    public void ValidInputNumberSize(String[] input){
        if(input.length != 6){
            throw new IllegalArgumentException("[ERROR] 입력한 숫자 개수가 6개가 아닙니다.");
        }
    }

    public void ValidInputNumberOverZero(String input){
        int number = Integer.parseInt(input);
        if(number < 0){
            throw new IllegalArgumentException("[ERROR] 음수를 입력 할 수 없습니다.");
        }
    }

    public void ValidInputNumberRange(String input){
        int number = Integer.parseInt(input);
        if(number < 0 || number > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
