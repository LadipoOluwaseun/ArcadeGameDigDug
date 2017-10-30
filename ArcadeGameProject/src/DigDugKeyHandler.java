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
				this.hero.updatePosition(0, -5);
//				 this.hero.moveUp();
			}
			
			if(key == 'k') {
				this.hero.updatePosition(0, 5);
//				 this.hero.moveDown();
			}
			
			if(key == 'l') {
				this.hero.updatePosition(5, 0);
//				 this.hero.moveRight();
			}
			
			if(key == 'j') {
				this.hero.updatePosition(-5, 0);
//				 this.hero.moveLeft();
			}
			
			if(key== 'c'){
				this.hero.extendCord();
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
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
		//
			
		}
		
		}

