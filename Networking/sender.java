package Networking;
/////////////////////////////////////////////////////////////////////////////*sender*/////////////////////////////////////////////////////////////////////////////
public class sender extends Thread{
	boxmassege box1  ; 
	String name ; 


	public sender (String name , boxmassege boxmass  ) {
		this.name =name ; 
		this.box1=boxmass;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <=6; i++) {
			box1.put(i );
			System.out.println("#:"+name+"put " +i);
			try {
				sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}


}/////////////////////////////////////////////////////////////////////////////*boxmassege*/////////////////////////////////////////////////////////////////////////////
class boxmassege {
	int  contents ;
	boolean avilable =false ;
	public int get () {
		while (avilable==false ) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} 
		avilable =false ; 
		return  contents;	
	} 
	public void  put(int val) {
		contents=val ;
		avilable =true; 
	}

}
/////////////////////////////////////////////////////////////////////////////*receiver*/////////////////////////////////////////////////////////////////////////////
class receiver extends Thread{
	boxmassege box2 ;
	String name ;
	public receiver (boxmassege boxmass , String name ) {
		this.name =name;
		this.box2=boxmass ;
	}
	public void run () {
		int val  =0 ;	


		do {
			val =box2.get();
			System.out.println("#" + name + " got: "+val);
		} while (val<6	 );
	}
}


