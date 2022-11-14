package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int LOTTO_PRICE = 1000;
    private int purchaseAmount;
    private int myQuantity;
    private List<Lotto> myLottos;

    public User(String purchaseAmount){
        validate(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
        myQuantity = this.purchaseAmount/LOTTO_PRICE;
        List<Lotto> myLottos = new ArrayList<>();
    }

    public void createUserLottos(){
        int temporaryQuantity = myQuantity;
        RandomGenerator randomGenerator = new RandomGenerator();

        while(temporaryQuantity != 0){
            List<Integer> randomNumbers = randomGenerator.generateSixNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            myLottos.add(lotto);
            temporaryQuantity--;
        }
    }

    public int getUserPurchaseAmount(){
        return purchaseAmount;
    }

    public int getUserPurchaseQuantity(){
        return myQuantity;
    }

    public List<List<Integer>> getUserLottos(){
        List<List<Integer>> userLottos = new ArrayList<>();

        for (Lotto myLotto: myLottos){
            List<Integer> userLotto = myLotto.getNumbers();
            userLottos.add(userLotto);
        }

        return userLottos;
    }

    private void validate(String purchaseAmount){
        validateNumeric(purchaseAmount);
        validateOverThousand(purchaseAmount);
        validateUnit(purchaseAmount);
    }

    private void validateNumeric(String purchaseAmount){
        boolean isNumeric = purchaseAmount.chars().allMatch(Character::isDigit);
        if (!isNumeric){
            throw new IllegalArgumentException("[ERROR] 구입 금액으로 숫자만 입력해야 합니다.");
        }
    }

    private void validateOverThousand(String purchaseAmount){
        if (Integer.parseInt(purchaseAmount) < LOTTO_PRICE){
            throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상의 금액을 입력해야 합니다.");
        }
    }

    private void validateUnit(String purchaseAmount){
        if (Integer.parseInt(purchaseAmount) % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
