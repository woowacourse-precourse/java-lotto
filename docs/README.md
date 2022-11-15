Lotto: 로또 한장 발행  
>makeLotto: 생성자  
getNumbers: 로또 한장 발행 시 생성 번호

LottoView: UI. 입력 및 출력  
>moneyInput: 구입 금액 입력  
winNumber: 당첨 번호 입력  
bonusNumber: 보너스 번호 입력  
winNumberValidation: 당첨 번호 유효성 검사  
bonusNumberValidation: 보너스 번호 유효성 검사  
sameValidation: 당첨번호/보너스 번호 중복 검사  
>
> printIssueLotto: 발행된 로또(LottoModel에 저장되어 있음) 출력  
> printResult: 당첨 결과 출력  
> printEarningRate: 수익률 계산 및 출력

LottoModel: 로또 정보(발행 로또, 당첨번호, 보너스번호) 저장  
private으로 저장 공간(리스트) 선언되어 있고, 메서드로 접근  
>saveWinNumbers: 당첨 번호 저장  
> getSavedWinNumbers: 저장된 당첨 번호 반환  
> saveBonusNumber: 보너스 번호 저장  
> getSavedBonusNumber: 저장된 보너스 번호 반환  
> saveIssueLotto: 발행된 로또 저장  
> getSavedIssueLotto: 저장된 발행 로또 반환

LottoController: 로또 당첨 로직  
>compareOneLotto: 한 장의 로또와 당첨 번호 비교  
> compareBonus: 한 장의 로또와 보너스 번호 비교  
> first: 1등 당첨 비교, 당첨 개수 출력  
> second, third, fourth,fifth : 
> 마찬가지로 2,3,4,5등 당첨 비교

LottoEnum: 로또 관련 상수 저장  
>한 장당 가격, 1등 당첨금, 2등 당첨금, 3등 당첨금,
> 4등 당첨금, 5등 당첨금

