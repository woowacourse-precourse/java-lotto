#  User Interface (UI)

**inputMoney**  

    금액을 입력 받음
    구매한 로또의 개수와 정보를 출력

#  금액 제한 설정(Money)
    MAX : 최대 금액 
    MIN : 최소 금액
    MOD : 금액 단위

#구매자 (Customer)
 
    금액을 입력 받고 금액이 올바르다면 저장

**valiedate**

    isntMod : 금액이 Mod으로 안나눠지는지 
    isPoor : 금액이 Money.MIN 보다 적은지
    isElonMusk : 금액이 Money.MAX 보다 많은지
    isBitCoin : 금액이 정수가 아닌지 ( 정규식과 일치하지 않는지 )

**setMoney**

    입력 받은 금액을 저장

**getMoney**

    고객의 금액 정보를 전달
#로또 저장소 (DB)

    생성된 로또를 저장하는 보관소

**insert**

    생성된 로또를 저장소에 추가

**selectAt**
   
    보관된 로또를 반환

#로또 판매점 (Store)

    구매자 정보 설정

**countLotto**

    구매자가 구매 가능한 로또 개수 파악

**makeLotto**

    로또 한개 발행

**saveLotto**
   
    발행된 로또를 DB에 저장

**buy**
    
    구매자가 구매 가능한 개수만큼 로또를 구매



    
