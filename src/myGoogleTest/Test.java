package myGoogleTest;

public class Test {

	public static void main(String[] args) {
		
		String S ="11a2g3j45FJ67k8";
		int K =3;
		
		
		S = S.replaceAll("-", "");
		int len = S.length();
		
		StringBuilder Sb = new StringBuilder(S.toUpperCase());
		
		while(len>K)
		{
			len = len -K; 
			Sb.insert(len, '-');
		}
		
		System.out.println(Sb.toString());

	}  

}
