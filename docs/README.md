# 로또 미션 수행하기

-------------
## 기능 목록
* 로또 개수만큼 매번 6개의 랜덤 넘버 추출하여 리스트에 담아 전체 리스트 하나에 추가하는 기능 - NumberGenerator#createRandomLotto()
    * 로또 번호 오름차순 정렬하는 기능 - NumberGenerator#ascendingOrder()
* 입력
    1. 로또 구입 금액 입력 - Application#askTotalPrice()
        * 로또 구입 금액/1000 을 하여 로또 개수 구하는 기능 - CountLotto#CountLotto()

            * 예외1 : 입력시 숫자가 아닐 경우 에러메시지([ERROR] 금액(숫자)를 입력해주세요.) 하고 while구문을 통해서 다시 입력받도록 함 - Application#validateNumber()
            * 예외2 : 1000미만의 수 입력시 IllegalArgumentException 발생, 에러메시지([ERROR] 1000원 이상의 금액만 입력하세요.) - LottoCount#validateNumber()
            * 예외3 : 1000원으로 나누어 떨어지지 않는 수 입력시 IllegalArgumentException 발생, 에러메시지([ERROR] 로또 1장당 1000원 입니다.) - LottoCount#validateDivideRight()
       
    2. 당첨 번호 6개 입력(구분자 : ,) - Application#askNumbers()
        * 사용자 입력 당첨 번호 리스트에 저장하는 기능 - Lotto#Lotto()
        * Lotto클래스에 저장된 리스트를 main으로 가지고 오는 기능 - Lotto#getLottoNumbers()

            * 예외1 : 입력시 ,로 나누어지지 않았을 경우 IllegalArgumentException 발생, 에러메시지([ERROR] 값을 ,로 구분해서 입력하세요.) - Application#validateSplit()
            * 예외2 : 1-45 사이의 숫자가 아닐 경우 IllegalArgumentException 발생 - Application#validateLottoNumber()
                * 에러메시지([ERROR] 숫자만 입력하세요.) 
                * 에러메시지([ERROR] 1-45사이의 숫자만 입력하세요.) 
            * 예외3 : 입력한 숫자의 개수가 6개가 아닐 경우 IllegalArgumentException 발생, 에러메시지([ERROR] 숫자의 개수가 6개가 아닙니다.) - Lotto#validate()
            * 예외4 : 입력 숫자 6개 중 하나라도 중복되는 경우 IllegalArgumentException 발생, 에러메시지([ERROR] 서로 다른 숫자 6개를 입력하세요.) - Lotto#noRepeatNumber()
        
    3. 보너스 번호 입력  - Application#askBonusNumber()
        * 사용자 입력 보너스 번호 리스트에 저장하는 기능 - BonusNumber#BonusNumber()
        * BonusNumber클래스에 저장된 bonusnumber를 main으로 가지고 오는 기능 - BonusNumber#getBonusNumber()

            * 예외1 : 1-45 사이 숫자가 아닐 경우 IllegalArgumentException 발생 -  BonusNumber#validateBonusNumber()
                * 에러메시지([ERROR] 숫자만 입력하세요.) 
                * 에러메시지([ERROR] 1-45사이의 숫자만 입력하세요.) 
          
            * 예외2 : 입력 숫자 6개와 보너스 번호가 중복되는 경우 IllegalArgumentException 발생, 에러메시지([ERROR] 보너스 번호가 입력된 당첨 번호 6개와 중복됩니다.) - BonusNumber#noRepeatBonus()
       
* 출력
    1. 발행한 로또 수량 및 번호 출력 - Print#printNumberAll()
    2. 당첨 내역 출력 - Print#printWin()
        * 1-5등까지의 당첨조건에 각각 몇번 해당하는지 세어 주는 기능 - Print#countWin()
            * enum을 활용해서 각각 몇번 해당하는지 세어주는 기능 - Print#countRank()
    3. 수익률 구하기 위해서 전체 금액 합산 / 로또구입금액 계산하는 기능 구현 - Print#printProfit()
        * 수익률 계산한값을 소수점 둘째자리에서 반올림 해준다음 출력하는 기능 구현 - Print#printProfitRound()
    
------------
## 단위 테스트 구현(도메인에 작성)
1. 핵심 로직
    
    * countWin() - ApplicationTest#기능테스트
        - 1-5등까지의 당첨조건에 각각 몇번 해당하는지 세어 주는 기능
        * countRank() 
            - enum을 활용해서 각각 몇번 해당하는지 세어주는 기능
    
    * printProfit() - ApplicationTest#기능테스트
        - 수익률 구하기 위해서 전체 금액 합산 / 로또구입금액 계산하는 기능

2. UI 로직

    * askTotalPrice()
        * 예외 체크
            - 입력시 숫자가 아닐 경우 - ApplicationTest#예외테스트
            - 1000미만의 수 입력시 - UIAskTotalPriceTest#PriceShouldBeLess1000
            - 1000원으로 나누어 떨어지지 않는 수 입력시 - UIAskTotalPriceTest#PriceShouldBeDividedBy1000

    * askNumbers()
        * 예외 체크
            - 입력시 ,로 나누어지지 않았을 경우 - UIAskNumbersTest#ShouldBeSplitedByComma()
            - 1-45 사이의 숫자가 아닐 경우 
                - 숫자가 아닐 경우 - UIAskNumbersTest#ShouldBeNumber()
                - 숫자이지만 1-45사이 숫자가 아닐 경우 - UIAskNumbersTest#ShouldBeNumbersOneToFortyFive()
            - 입력한 숫자의 개수가 6개가 아닐 경우 - LottoTest#CreateLottoByOverSize()
            - 입력 숫자 6개 중 하나라도 중복되는 경우 - LottoTest#createLottoByDuplicatedNumber()

    * askBonusNumber()
        * 예외 체크
            - 1-45 사이 숫자가 아닐 경우 
                - 숫자가 아닐 경우  - UIAskBonusNumberTest#ShouldBeNumber()
                - 숫자이지만 1-45사이 숫자가 아닐 경우 - UIAskBonusNumberTest#ShouldBeNumbersOneToFortyFive()
            - 입력 숫자 6개와 보너스 번호가 중복되는 경우 - UIAskBonusNumberTest#NoDuplicateBonusNumber()
        
    * printNumberAll() - ApplicationTest#기능테스트
        - 발행한 로또 수량 및 번호 출력 

    * printWin() - ApplicationTest#기능테스트
        - 당첨 내역 출력

    * printProfitRound() - ApplicationTest#기능테스트
        - 수익률 계산한값을 소수점 둘째자리에서 반올림 해준다음 출력

------------
## 기능 요구 사항
* 로또 번호 숫자 범위 1-45까지
* 로또 번호는 중복되지 않는 6개의 숫자
* 입력 로또 번호는 중복되지 않는 6개 숫자 + 보너스 번호 1개
* 당첨은 1등부터 5등까지
    * 1등: 6개 번호 일치 / 2,000,000,000원
    * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    * 3등: 5개 번호 일치 / 1,500,000원
    * 4등: 4개 번호 일치 / 50,000원
    * 5등: 3개 번호 일치 / 5,000원
* 로또 구입 금액 입력하면 구입금액에 해당하는 숫자 만큼 로또를 발행해야 함.(로또 1장 가격 1000)
* 당첨 번호와 보너스 번호는 입력받기
* 사용자가 입력한 로또 번호와 당첨 번호 비교하고 당첨 내역 및 수익률 출력, 게임 종료.
* 잘못된 값 입력 시 IllegalArgumentException 발생시키기, [ERROR]로 시작하는 에러 메시지 출력하고 종료.