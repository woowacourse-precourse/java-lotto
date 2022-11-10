package lotto;

import java.text.DecimalFormat;

public enum Prize
{
    First("6개 일치",2_000_000_000),
    Second("5개 일치, 보너스 볼 일치 ",30_000_000),
    Third("5개 일치",1_500_000),
    Fourth("4개 알치",50_000),
    Fifth("3개 일치",5_000);

    private final String info;
    private final Money price;

    Prize(String info,Integer price)
    {
        this.info = info;
        this.price = new Money(price);
    }

    public Integer getPrice()
    {
        return price.money;
    }


    @Override
    public String toString()
    {
        return String.join(" ",info,price.toString());
    }

    private static class Money
    {
        DecimalFormat priceFormat = new DecimalFormat("###,###");
        int money;

        Money(int price)
        {
            this.money = price;
        }

        @Override
        public String toString()
        {
            return "(" + priceFormat.format(money) +")";
        }
    }






}
