package lotto;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers){
        final int LIMIT_OF_SIZE = 6;
        if (numbers.size() != LIMIT_OF_SIZE){
            System.out.println("[ERROR] 당첨 번호는 정확히 6개를 입력하셔야 합니다.");
            throw new IllegalArgumentException();
        }
        checkOverLap(numbers);
    }
    private void checkOverLap(List<Integer> numbers){
        Iterator itrForNumbers = numbers.iterator();
        boolean[] arrayForCheckOverLap = initializeBooleanArray(46);
        while (itrForNumbers.hasNext()){
            int checkIndex = (int)itrForNumbers.next();
            if (arrayForCheckOverLap[checkIndex] == true){
                System.out.println("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
                throw new IllegalArgumentException();
            }
            arrayForCheckOverLap[checkIndex] = true;
        }
    }
    private boolean[] initializeBooleanArray(int limitOfArray){
        boolean[] tempArray = new boolean[limitOfArray];
        for (int index = 0; index < limitOfArray; index++){
            tempArray[index] = false;
        }
        return tempArray;
    }
    public ArrayList<BigInteger> countLottoWinnings(ArrayList<ArrayList<Integer>> lotteryBundleArray, int bonusWinningNumber){
        final int SET_TO_INDEX_VALUE = 3;
        ArrayList<BigInteger> countWinningNumbersCaseArray = initializeArray();
        for (ArrayList<Integer> lottery : lotteryBundleArray){
            int settedIndex = 0;
            try{
                settedIndex = countWinningNumbers(lottery,bonusWinningNumber)-SET_TO_INDEX_VALUE;
            }
            catch(Exception e){
                throw e;
            }
            setArrayValue(countWinningNumbersCaseArray, settedIndex);
        }
        return countWinningNumbersCaseArray;
    }
    private void setArrayValue(ArrayList<BigInteger> countWinningNumbersCaseArray, int settedIndex) {
        if (settedIndex >= 0){
            countWinningNumbersCaseArray.set(settedIndex, countWinningNumbersCaseArray.get(settedIndex).add(new BigInteger("1")));
            System.out.println(countWinningNumbersCaseArray.get(settedIndex));
        }
    }
    private ArrayList<BigInteger> initializeArray(){
        ArrayList<BigInteger> countWinningNumbersCaseArray = new ArrayList<>();
        for (int index = 0; index < 5; index++){
            countWinningNumbersCaseArray.add(new BigInteger("0"));
        }
        return countWinningNumbersCaseArray;
    }
    private int countWinningNumbers(ArrayList<Integer> lottery, int bonusWinningNumber){
        try{
            validateOverlap(bonusWinningNumber);
        }
        catch (Exception e){
            throw e;
        }
        return getcountWinningNumbers(lottery,bonusWinningNumber,0);
    }
    private void validateOverlap(int bonusWinningNumber) {
        if (numbers.contains(bonusWinningNumber)){
            System.out.println("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    private int getcountWinningNumbers(ArrayList<Integer> lottery, int bonusWinningNumber, int countOfWinningNumbers) {
        for (int index = 0; index < lottery.size(); index++){
            if (numbers.contains(lottery.get(index))){
                countOfWinningNumbers++;
            }
        }
        if (lottery.contains(bonusWinningNumber)) {
            countOfWinningNumbers += 2;
        }
        return countOfWinningNumbers;
    }
    public void printLottoWinningsResult(ArrayList<BigInteger> resultArray, int buyingAmount){
        BigInteger sumOfWinAmount = new BigInteger("0");
        System.out.println("\n당첨 통계\n---");
        sumOfWinAmount = sumOfWinAmount.add(printCase3Correct(resultArray.get(0)));
        sumOfWinAmount = sumOfWinAmount.add(printCase4Correct(resultArray.get(1)));
        sumOfWinAmount = sumOfWinAmount.add(printCase5Correct(resultArray.get(2)));
        sumOfWinAmount = sumOfWinAmount.add(printCase5BonusCorrect(resultArray.get(4)));
        sumOfWinAmount = sumOfWinAmount.add(printCase6Correct(resultArray.get(3)));
        printPercentOfProfit(sumOfWinAmount, Integer.toString(buyingAmount));
    }
    private BigInteger printCase3Correct(BigInteger countForCase){
        BigInteger tempInteger = new BigInteger("5000");
        System.out.println("3개 일치 (5,000원) - " + countForCase + "개");
        return tempInteger.multiply(countForCase);
    }
    private BigInteger printCase4Correct(BigInteger countForCase){
        BigInteger tempInteger = new BigInteger("50000");
        System.out.println("4개 일치 (50,000원) - " + countForCase + "개");
        return tempInteger.multiply(countForCase);
    }
    private BigInteger printCase5Correct(BigInteger countForCase){
        BigInteger tempInteger = new BigInteger("1500000");
        System.out.println("5개 일치 (1,500,000원) - " + countForCase + "개");
        return tempInteger.multiply(countForCase);
    }
    private BigInteger printCase5BonusCorrect(BigInteger countForCase){
        BigInteger tempInteger = new BigInteger("30000000");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countForCase + "개");
        return tempInteger.multiply(countForCase);
    }
    private BigInteger printCase6Correct(BigInteger countForCase){
        BigInteger tempInteger = new BigInteger("2000000000");
        System.out.println("6개 일치 (2,000,000,000원) - " + countForCase + "개");
        return tempInteger.multiply(countForCase);
    }
    private void printPercentOfProfit(BigInteger sumOfWinAmount, String buyingAmountString){
        BigInteger buyingAmount = new BigInteger(buyingAmountString);
        double percentOfProfit = sumOfWinAmount.doubleValue()/buyingAmount.doubleValue()*100;
        percentOfProfit = Math.round(percentOfProfit * 100)/100.0;
        System.out.println("총 수익률은 "+percentOfProfit+"%입니다.");
    }
}
