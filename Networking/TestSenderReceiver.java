package Networking;

public class TestSenderReceiver {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		boxmassege mb =new boxmassege();
//		sender send =new sender ("ahmad ",mb);
//		receiver receive= new receiver(mb, "mohamed");
//		send.start();
//		receive.start();
//		//////////////////////*///////////////////////////////
	/*
	 * Update conversation between sender and receiver through synchronized processes
	 */
		massegeboxsync mb1 = new massegeboxsync();
		sendersync sender1 = new sendersync(mb1, "ahmad");
		ReceiverSync receiver = new ReceiverSync(mb1, "dregat");
		sender1.start();
		
		try{
		Thread.sleep (100);	
		}
		catch (InterruptedException e){}
		receiver.start();
	}

}
