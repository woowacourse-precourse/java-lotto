> ## 클래쓰 정리  
> 1. ### Purchase Class 
>   - 로또 구매자 클래쓰
>   - 구입 금액 및 금액에 따른 로또 번호들을 저장
>   
> 2. ### Lotto Class 로또 클래쓰
>   - 로또와 관련된 클래쓰
>   - 구매자의 로또 번호
>   - 당첨번호의 로또 번호 및 보너스 번호
>   
> 3. ### Error enum 
>   - 해당 로또 어플리케이션과 관련된 Error를 관리하는 열거체
>   
> 4. ### Validation Class 
>   - 모든 유효성 검증 함수들을 관리하는 클래쓰
>   
> 5. ### WinningResult enum
>   - 당첨 결과를 저장하는 열거체
>   
> 5. ### Calculations Class
>   - 당첨 결과를 계산하는 클래쓰
>   
> 5. ### Outputs Class
>   - 당첨 결과를 출력하는 클래쓰


--- 
> ## Application Flow
> - 아래 번호 순서대로 Application을 실행한다.
> > ### Purchaser Class
> > > 1. Purchaser.setCost() : 로또 구입 금액 입력 받기
> > >   - Validations.checkCostValid() 입력 금액 유효성 체크
> > > 2. Purchaser.receiveLottoNumbers() : 로또 번호들 부여받기
> > >   - 구매한 만큼의 new Lotto() 객체가 구매자의 로또 번호들을 관리하는 클래쓰 변수에 생성됨.
> > > 3. Purchaser.printLottoNums() : 부여 받은 로또 번호들 출력
> > ### Lotto Class
> > > 4. new Lotto() : 로또 당첨 번호 생성
> > >   - Validations.checkLength(): 길이 체크
> > >   - Validations.checkDuplication(): 중복성 체크
> > > 5. Lotto.setBonusNumber() : 로또 보너스 번호 입력
> > >   - Validations.checkBonusNumberIsNumeric(): 보너스 번호 숫자 체크
> > >   - Validations.checkBonusNumberDuplicate(): 보너스 번호 중복 체크
> > >   - Validations.checkNumberRange(): 보너스 번호 범위(1~45) 체크
> > ### Calculations Class
> > > 8. Calculations.calculateWinningDetails() : 당첨 결과 계산
> > > 9. Calculation.calculateTotalEarns() : 총 당첨 금액 계산
> > ### Outputs Class
> > > 10. Outputs.printWinningDetails() : 당첨 내역 출력
> > > 11. Outputs.printEarningRatio() : 수익률 출력
 