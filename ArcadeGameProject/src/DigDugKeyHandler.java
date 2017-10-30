import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DigDugKeyHandler implements KeyListener{
		DigDugWorld world;
		
		DigDugKeyHandler(DigDugWorld world) {
			this.world = world;
			System.out.println("world");
		}
	
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("gwf ");
			char key = e.getKeyChar();
			if(key == 'u') {
				System.out.println(1);
				world.changeLevel(true);
			}
			
			if(key == KeyEvent.VK_D) {
				world.changeLevel(false);
			}
			
			if(key == KeyEvent.VK_UP) {
//				 Hero.moveUp();
			}
			
			if(key == KeyEvent.VK_DOWN) {
//				 Hero.moveDown();
			}
			
			if(key == KeyEvent.VK_RIGHT) {
//				 Hero.moveRight();
			}
			
			if(key == KeyEvent.VK_LEFT) {
//				 Hero.moveLeft();
			}
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyChar();
			if(key == KeyEvent.VK_U) {
				System.out.println(1);
				world.changeLevel(true);
			}
			
			if(key == KeyEvent.VK_D) {
				world.changeLevel(false);
			}
			
			if(key == KeyEvent.VK_UP) {
//				 .moveUp();
			}
			
			if(key == KeyEvent.VK_DOWN) {
//				 Hero.moveDown();
			}
			
			if(key == KeyEvent.VK_RIGHT) {
//				 Hero.moveRight();
			}
			
			if(key == KeyEvent.VK_LEFT) {
//				 Hero.moveLeft();
			}
			
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
			int key = e.getKeyChar();
			if(key == 'u') {
				System.out.println(1);
				world.changeLevel(true);
			}
			
			if(key == KeyEvent.VK_D) {
				world.changeLevel(false);
			}
			
			if(key == KeyEvent.VK_UP) {
//				 Hero.moveUp();
			}
			
			if(key == KeyEvent.VK_DOWN) {
//				 Hero.moveDown();
			}
			
			if(key == KeyEvent.VK_RIGHT) {
//				 Hero.moveRight();
			}
			
			if(key == KeyEvent.VK_LEFT) {
//				 Hero.moveLeft();
			}
			if(key == KeyEvent.VK_Q) {
				//Hero.extendCord();
				//time.sleep();
				//Hero.retractCord();
			}
			
		}
		
		}

