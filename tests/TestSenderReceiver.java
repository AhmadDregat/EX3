package tests;

public class TestSenderReceiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boxmassege mb =new boxmassege();
		sender send =new sender ("ahmad ",mb);
		receiver receive= new receiver(mb, "mohamed");
		send.start();
		receive.start();
	}

}
