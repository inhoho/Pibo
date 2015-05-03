package pibo;

public class Main {
	
	/*
	 * main test
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pibo test=new pibo(1);
		for(int i=1;i<50;i++){
			test.InputNum(i);
			System.out.println(i+" : "+test.Find_real_chick_number());
	
		}
	}

}
