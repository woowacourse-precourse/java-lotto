#  User Interface (UI)

**inputMoney**  

    구매자 금액을 입력 받음
    구매한 로또의 개수와 정보를 출력
    당첨 번호를 입력 받음
    보너스 번호를 입력 받음

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

#당첨 금액 분류 (Winner)

    일치하는 번호의 수에 따른 금액을 반환
    일치하는 개수에 따른 상금 정보 Enum
    일치하는 개수에 따른 통계리스트 인덱스 정보

#당첨 번호 분류 (Numbers)

    당첨 번호 검증을 위한 정규식 보관

#당첨 확인 (Saturday)
    
    당첨 번호를 정렬해 보관
    당첨 번호와 DB의 로또들을 비교
    당첨일 경우 당첨의 통계를 냄
    당첨액의 수익률을 계산

**Saturday**

    입력된 당첨 번호를 정렬해 저장

**validate**

    전달된 당첨 번호와 보너스 번호가 정상인지 확인
    isntWinRegex : Win 정규식과 다르면 false
    isOut : 45보다 큰 번호이면 false
    isntBonusReges : Bonus 정규식과 다르면 false
    isAlready : Bonus 값과 Win의 값들중 같은 값이 있는 경우

**checkNumber**

    숫자가 당첨 번호에 있을경우 true

**checkLotto**
    
    로또와 당첨번호를 비교해 일치하는 개수 반환

**makeStatistics**

    DB의 모든 로또들을 check 하고 통계를 저장

**calYeild**

    상금의 수익률을 계산하는 기능