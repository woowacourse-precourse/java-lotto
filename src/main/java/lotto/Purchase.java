package lotto;


public class Purchase {
    public int price;
    public Purchase(String price) throws IllegalArgumentException{
        validatePurchase(price);
        this.price = Integer.parseInt(price);
    }
    private void validatePurchase(String price) throws IllegalArgumentException{
        for(int i=0; i<price.length(); i++){
            if(price.charAt(i)>=48 && price.charAt(i)<=57){
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값 숫자로만 입력");
        }
        if(Integer.parseInt(price)%1000 ==0){
            return ;
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 입력 값 1000원 단위로 입력");
    }
}
