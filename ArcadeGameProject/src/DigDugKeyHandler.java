import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DigDugKeyHandler implements KeyListener{
		DigDugWorld world;
		Hero hero;
		
		DigDugKeyHandler(DigDugWorld world) {
			this.world = world;
			this.hero = world.getHero();
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
				 this.hero.moveUp();
			}
			
			if(key == 'k') {
				 this.hero.moveDown();
			}
			
			if(key == 'l') {
				 this.hero.moveRight();
			}
			
			if(key == 'j') {
				 this.hero.moveLeft();
			}
			
			if(key== 'c'){
				this.hero.extendCord();
			}
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			//
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
		//
			
		}
		
		}

