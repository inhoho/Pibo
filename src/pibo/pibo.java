package pibo;
/*
 * author : inhoho
 * date : 2014. 12. 18
 * what the... this class?
 *  This class find a number that we eat the chicken.
 *  method of data's input is InputNum(int n). 
 *  you can use int Find_real_chick_number() method.
 * LET'S EAT THE CHICKEN!! 
 */
public class pibo {
	int PeopleNum;
	int ChickNum;
	pibo(int n){
		PeopleNum=n;
	}
	public void InputNum(int num){
	/*
	 * 값을 받는 부분 input data
	 */
		PeopleNum=num;
	}
	int Pibonacci(int PeopleNum){
		/*
		 *  피보나치 수열부분.
		 *  fibonacci part;
		 *  f로시작하지만 다 만들고 발견해서.. 수정은 안하겠다.
		 */
		if (PeopleNum==1)	{
			return 1;
		}
		else if(PeopleNum==2){
			return 1;
		}
		else if(PeopleNum<0){
			return 0;
		}else{
			return Pibonacci(PeopleNum-1)+Pibonacci(PeopleNum-2);
		}
	}
	int Howtime(){
		int times=1;
		for(int i=1;i<=PeopleNum;i++){
			if(PeopleNum<=Pibonacci(i)){
				times=i-2;
				break;
			}
		}
		return times;
	}
	boolean Is_P_number(){
		for(int i=1; i<=PeopleNum;i++){
			if(Pibonacci(i)==PeopleNum){
				return true;				
			}
		}
		if(PeopleNum==1||PeopleNum==2||PeopleNum==3){
			return true;
		}
		return false;
	}
	boolean Is_P_number(int num){
		for(int i=1; i<=num;i++){
			if(Pibonacci(i)==num){
				return true;				
			}
		}
		if(num==1||num==2||num==3){
			return true;
		}
		return false;
	}
	int Make_non_P(){
		int npnum=0;
		int Mainnum=0;
		int CPeople=PeopleNum;
		
		if(CPeople==4){
			return 3;// 4명까지는 값이 순서보다 작기때문에 써야되는데 4는 또 결과에 있지도 않아서 더 문제가 된다.
		}
		/*
		 * 6 = 5+1
		 * 7 = 5+2
		 * 9 = 8+1
		 * 이런식으로 간다. 즉 가장 가까운 수를 빼서 찾는 방식으로 할수 있다. 
		 * 재귀로도 할수 있을것 같다.
		 * 1,2,3,4는 직접 설정해야 된다.
		 */
		while(true){
		
	//		System.out.println(CPeople+" after cp break");
		for(int i=1;i<=CPeople;i++){
			
			if(CPeople<=Pibonacci(i)){
				Mainnum=i-1;
				break;
			}else if(CPeople==1||CPeople==2){
				Mainnum=3;
				break;
			}else if(CPeople==3){
				Mainnum=4;
			}else if(CPeople==4){
				Mainnum=5;
			}else if(Is_P_number(CPeople)){
				Mainnum=i;
			}
		}
			npnum+=Pibonacci(Mainnum-1);
			CPeople-=Pibonacci(Mainnum);
/*
			System.out.println(Mainnum+" after main break");
			System.out.println(npnum+" after np break");
			System.out.println(CPeople+" after cp break");
	*/
			if(CPeople<2)
				break;
		}
		
		return npnum;
	}
	int Find_real_chick_number(){
		if(Is_P_number()){
			ChickNum=Pibonacci(Howtime());
		}
		if(PeopleNum==1||PeopleNum==2){
			ChickNum=1;
		}else if(PeopleNum==3){
			ChickNum=2;}
		else{
			ChickNum=Make_non_P();
		}
		
		return ChickNum;
	}
}
