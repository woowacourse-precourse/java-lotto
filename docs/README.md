> ## 기능 정리  
> 1. ### 로또 번호 구입 금액 입력받기
> | 함수명                    | 내용        | 비고                         | 
> |--------------------------|--------------------|---------------------|
> | **setPurchaseAmount()**  | 구입 금액 입력받기| validPurchaseAmount() 함수로 유효성 검증 |
> | **pickRandomNumbers()**  | 구입한 개수만큼의 로또 번호 생성| -            |
>2. ### 당첨 번호 입력하기
> | 함수명                  | 내용          | 비고                            | 
> |-------------|-------------------------------|---------------|
> | **setLottoNumber()** | 로또 당첨 번호 입력 | validLottoNumber() 함수로 유효성 검증 |
> | **setBonusNumber()**     | 보너스 번호 입력   | validBonusNumber() 함수로 유효성 검증 |
> 3. ### 당첨 통계 출력
> | 함수명                       | 내용       | 비고                            | 
> |----------|-------------------------------|---------------|
> | **getWinningDetails()** | 당첨 내역 계산 | -                          |
> | **calculateEarningRatio()** | 수익률 계산   | -                          |
> | **printWinningDetails()** | 당첨 내역 출력 | - |
> | **printEarningRatio()** | 수익률 출력   | - |
--- 
> ## Application Flow
> - 아래 번호 순서대로 Application을 실행한다.
> > ### Purchaser Class
> > > 1. Purchaser.setPurchaseAmount() : 로또 구입 금액 입력 받기
> > > 2. Purchaser.validPurchaseAmount() : 구입 금액 유효성 체크
> > > 3. Purchaser.pickRandomNumbers() : 구입한 개수만큼의 로또 번호 생성
> > ### Lotto Class
> > > 4. Lotto.setLottoNumber() : 로또 당첨 번호 입력
> > > 5. Lotto.validLottoNumber() : 로또 당첨 번호 유효성 체크
> > > 6. Lotto.setBonusNumber() : 로또 보너스 번호 입력
> > ### Application Class
> > > 7. Application.getWinningDetails() : 당첨 내역 계산
> > > 8. Application.calculateEarningRatio() : 수익률 계산
> > > 9. Application.printWinningDetails() : 당첨 내역 출력
> > > 10. Application.printEarningRatio() : 수익률 출력
 