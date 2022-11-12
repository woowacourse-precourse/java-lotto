package lotto.service;

import lotto.domain.User;
import lotto.domain.ValidUserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottoNumberService {
    private final String[] lottoNumber = User.getUserInputLottoNumber();

    // 생성자에서 검증하고 싶지만 "," 로 나뉘기 때문에 어쩔 수 없이 안에서 검증
    public List<Integer> getLottoNumber(){
        List<Integer> lottoNumbers = new ArrayList<>(Collections.emptyList());

        for (String number : lottoNumber) { // 입력받은 로또 번호 숫자인지 검증
            ValidUserInput.ValidInputNumberInteger(number);
            ValidUserInput.ValidInputNumberOverZero(number);
            ValidInputNumberOverZero(number);
            ValidInputNumberRange(number);

            lottoNumbers.add(Integer.parseInt(number)); //통과했다면 List<>에 넣어줌
        }
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public UserLottoNumberService() {
        ValidInputNumberSize(lottoNumber);
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
