package lotto;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

public class Application {
    public static void main(String[] args) {
    	List<Integer> testData = List.of(1, 2, 3, 4, 5);
    	
    	IoData.inputNum();
        IoData.inputBonus();
        IoData.inputMoney();
        IoData.inputDupErr();
        IoData.inputDefErr();
        
        IoData.result(testData);
    }
}
