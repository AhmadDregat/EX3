package tests;

public class Game {
	final static Object run_lock= new Object() ,stop_lock =new Object(), Play_lock =new Object();

	private String play_state ="Play", Stop_state ="Stop ",start_state="start";
	private String state ;
	private Player p ; 
	public void Start() {
		new Game().Start();
	}
	public void Start(int i) {
		new Game().Start(i);
	}
	public void Stop() {
		new Game().Stop();
	}
	public void Stop(int i) {
		new Game().Stop(i);
	}
	public void Play() {
		new Game().Play();
	}
	public void Play(int i) {
		new Game().Play(i);
	}
	public Boolean IsRaedy() {
		return state.equals(Stop_state);
	}
	public Boolean isRunning() {
		return state.equals(play_state);
		
	}
	public Boolean  Fineshed () {
		return state.equals(Stop_state);
	}
class Game_starter extends Thread implements GameInterfaces.StarttheGame{
	
}
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
