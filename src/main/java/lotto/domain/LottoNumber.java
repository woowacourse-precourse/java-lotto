package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final String ERROR_INPUT_NUMBER = "[ERROR] 로또 개수는 6개 입니다.";
    private static final String ERROR_TYPE_NUMBER = "[ERROR] 로또 입력 형식을 맞춰주세요.";
    private static final String ERROR_OVERLAP_NUMBER = "[EEROR] 로또 숫자가 중복되었습니다.";

    private static final int COUNT_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    static List<String> checkNumber;

    public LottoNumber(String lottoNumber){
        try {
            validate(lottoNumber);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();

        }
        this.lottoNumbers = convertStringArrToIntegerList(lottoNumber);
    }
    public List<Integer> getLottoNumbers(){
        return this.lottoNumbers;
    }
    public static void clear() {
        checkNumber = new ArrayList<>();
    }

    private void validate(String request) {
        if (!isCorrectSize(request)) {
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER);
        }
        if(!isRightLottoNumbersType(request)){
            throw new IllegalArgumentException(ERROR_TYPE_NUMBER);
        }
        if(!isOverLapNumber(request)){
            throw new IllegalArgumentException(ERROR_OVERLAP_NUMBER);
        }
    }
    // TODO: 추가 기능 구현
    public static List<Integer> convertStringArrToIntegerList(String numbers) {
        return List.of(numbers.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static boolean isOverLapNumber(String request) {
        clear();
        checkNumber = Arrays.asList(request.split(","));
        for (int i = 0; i < checkNumber.size(); i++) {
            int numberCount = Collections.frequency(checkNumber, checkNumber.get(i));
            if (numberCount > COUNT_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRightLottoNumbersType(String request) {
        for(int i=1; i<request.length()-1; i++){
            if(request.charAt(i) == ',' && (!(Character.isDigit(request.charAt(i-1)))||
                    !(Character.isDigit(request.charAt(i+1))))){
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectSize(String request) {
        clear();
        checkNumber = Arrays.asList(request.split(","));
        if (checkNumber.size() != LOTTO_SIZE) {
            return false;
        }
        return true;
    }
}
