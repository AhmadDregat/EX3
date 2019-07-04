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
	public boolean  has_started () {
		return state.equals(start_state);
		
	}
	public Boolean isRunning() {
		return state.equals(play_state);

	}
	public Boolean  Fineshed () {
		return state.equals(Stop_state);
	}
	class Game_starter extends Thread implements GameInterfaces.StarttheGame{
		int index ;
		Game_starter (){
			index=-1;

		}
		Game_starter (int i ){
			index=i ;

		}
		public void run () {
			synchronized (Play_lock) {

				while (!IsRaedy())
					try {
						Thread.sleep(1000);

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
			start(p);

		}
	
		@Override
		public void start(Player p) {
			// TODO Auto-generated method stub
				p.start(index);
			state=start_state;

		} 


	}
	class Game_stop extends Thread implements GameInterfaces.StoptheGame{
		int index ;
		Game_stop (){
			index=-1;

		}
		Game_stop (int i ){
			index=i ;

		}
		public void run () {
			synchronized (Play_lock) {

				while (!isRunning())
					try {
						Thread.sleep(1000);

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
		Stop(p);

		}
	
		@Override
		public void Stop(Player p) {
			// TODO Auto-generated method stub
				p.stop(index);
			state=Stop_state;

		}
	


	}
	class Game_Play extends Thread implements GameInterfaces.PlaytheGame{
		int index ;
		Game_Play (){
			index=-1;

		}
		Game_Play (int i ){
			index=i ;

		}
		public void run () {
			synchronized (Play_lock) {

				while (!(has_started()))
					try {
						Thread.sleep(1000);

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
			}
			Play(p);

		}
	
		@Override
		public void Play(Player p) {
			// TODO Auto-generated method stub
				p.Play(index);
			state=play_state;

		} 


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
