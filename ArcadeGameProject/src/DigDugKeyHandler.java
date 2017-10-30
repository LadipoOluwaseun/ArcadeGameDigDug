import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DigDugKeyHandler implements KeyListener{
		DigDugWorld world;
		
		DigDugKeyHandler(DigDugWorld world) {
			this.world = world;
//			System.out.println("world");
		}
	
		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("gwf ");
			char key = e.getKeyChar();
			if(key == 'u') {
				world.changeLevel(true);
			}
			
			if(key == 'd') {
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
			//
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
		//
			
		}
		
		}

