package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetLotto {
    public String getLottoNumbers() {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String getNumbers;

        try {
            getNumbers = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return getNumbers;
    }

    public List<Integer> cutNumbers(String getNumbers) {
        String[] lottoNumbers = getNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < lottoNumbers.length; i++) {
            numbers.add(Integer.parseInt(lottoNumbers[i]));
        }
        return numbers;
    }

    public int getBonusNumber() {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String getNumbers;
        int number;

        try {
            getNumbers = br.readLine();
            number = Integer.parseInt(getNumbers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return number;
    }
}
