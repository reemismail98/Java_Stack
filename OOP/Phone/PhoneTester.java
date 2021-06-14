package Phone;

public class PhoneTester {

	public static void main(String[] args) {
		IPhone iphoneten=new IPhone("X",100,"AT&T","zing");
		Galaxy S9=new Galaxy("S9",99,"Verizon","Ring Ring Ring");
		S9.displayInfo();
		System.out.println(S9.ring());
		System.out.println(S9.unlock());
		iphoneten.displayInfo();
		System.out.println(iphoneten.ring());
		System.out.println(iphoneten.unlock());
	}

}
