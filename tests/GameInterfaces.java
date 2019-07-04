package tests;

import tests.Game.Player;

public interface GameInterfaces {
	
	interface StarttheGame   {
		public void start (Player p );

	}
	
	interface PlaytheGame  {
		public void Play (Player p );
	}
	
	interface StoptheGame   {
		public void Stop  (Player p );
	}
}
