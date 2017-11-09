
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class DigDugKeyHandler implements KeyListener{
		DigDugWorld world;
		Hero hero;
		String direction;
		int distanceToMove;
		
		DigDugKeyHandler(DigDugWorld world) {
			this.world = world;
			this.hero = world.getHero();
			this.distanceToMove = DigDugWorld.getDistanceToMoveHeroWhenButtonIsPressed();
//			System.out.println("world");
		}
	
		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("gwf ");
			char key = e.getKeyChar();
			if(key == 'u') {
				this.world.changeLevel(true);
			}
			
			if(key == 'd') {
				this.world.changeLevel(false);
			}
			
			if(key == 'i') {
				this.hero.updatePosition(0, this.distanceToMove*(-1));
//				 this.hero.moveUp();
				this.direction = "up";
			}
			
			if(key == 'k') {
				this.hero.updatePosition(0, this.distanceToMove);
//				 this.hero.moveDown();
				this.direction = "down";
			}
			
			if(key == 'l') {
				this.hero.updatePosition(this.distanceToMove, 0);
//				 this.hero.moveRight();
				this.direction = "right";
			}
			
			if(key == 'j') {
				this.hero.updatePosition(this.distanceToMove*(-1), 0);
//				 this.hero.moveLeft();
				this.direction = "left";
			}
			
			if(key== 'c'){
				this.hero.extendCord();
			}
			
			if(key == 'p') {
				boolean isPaused = this.world.getIsPaused();
				isPaused = !isPaused;
				this.world.setIsPaused(isPaused);
//				if (isPaused) {
//					pauseResumeButton.setText("Resume");
//				} else {
//					pauseResumeButton.setText("Pause");
//				}
			}
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			char key = e.getKeyChar();
			if(key == 'i') {
				this.hero.updatePosition(0, 0);
//				 this.hero.moveUp();
			}
			
			if(key == 'k') {
				this.hero.updatePosition(0, 0);
//				 this.hero.moveDown();
			}
			
			if(key == 'l') {
				this.hero.updatePosition(0, 0);
//				 this.hero.moveRight();
			}
			
			if(key == 'j') {
				this.hero.updatePosition(0, 0);
//				 this.hero.moveLeft();
			}
			
			if(key=='c'){
				this.hero.retractCord();
			}
		}
			
			public void keyTyped(KeyEvent e) {
			
			}
				
			
}

