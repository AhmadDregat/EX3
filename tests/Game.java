package tests;

public class Game {
	final static Object run_lock= new Object() ,stop_lock =new Object(), Play_lock =new Object();
	
	private String play_state ="Play", Stop_state ="Stop ",start_state="start";
	private String state ;
	private Player p ; 
	
	
	
class Player  {
	public void start (int index) {
		if (index ==-1) {
			System.out.println("Player is in  start state ");
			
		}
		else {
			System.out.println("Player is in  start state "+index);
			
		}
	}
	public void stop (int index ) {
		if (index ==-1) {
			System.out.println("Player is in stop state ");
		}
		else {
			System.out.println("Player is in stop state "+index);
		}
	}
	public void Play (int index) {
		if (index ==-1) {
			System.out.println("Player is in  Play state ");
			
		}
		else {
			System.out.println("Player is in  Play state "+index);
			
		}
	}
	
}
}
