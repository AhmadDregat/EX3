package Networking;


public class sendersync extends Thread{

	private massegeboxsync messBox;
	private String name;
	public sendersync(massegeboxsync messBox, String name){
		this.messBox = messBox;
		this.name = name;
	}
	public void run(){
		for (int i=1; i<=5; i++){
			messBox.put(i);
			System.out.println("#"+name+" put: "+i);
		}
	}

}
class massegeboxsync{
	int contents ;
	boolean avilable =false ; 
	public synchronized int get() {
		while (!avilable ) {



			try {
				wait(); // wait for sender to write and notify
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		avilable=false ;// before return message, rest the flag
		notify();// notify sender
		return  contents;


	}
	public void  put (int val ) {
		synchronized (this ) {
			while(avilable) {


				try {
					wait();
				} catch (Exception e) {
					// TODO: handle exception
				}	
			}
			contents=val  ;
			avilable=true ;

			notify();

		}
	}
}
class ReceiverSync extends Thread{
	private massegeboxsync messBox;
	private String name;
	public ReceiverSync(massegeboxsync messBox, String name){

		this.messBox = messBox;
		this.name = name;
	}
	public void run(){
		int val = 0;
		do{
			val = messBox.get();
			System.out.println("#" + name + " got: "+val);
		}while (val<5);
	}
}	

