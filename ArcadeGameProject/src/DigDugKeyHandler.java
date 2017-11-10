
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;



public class DigDugKeyHandler implements KeyListener{
		DigDugWorld world;
		Hero hero;
		String direction;
		DigDugFrame frame;
		int distanceToMove;
		double count;
		
		DigDugKeyHandler(DigDugWorld world,DigDugFrame frame) {
			this.world = world;
			this.hero = world.getHero();
			this.distanceToMove = DigDugWorld.getDistanceToMoveHeroWhenButtonIsPressed();
			this.frame = frame;

		}
	
		@Override
		public void keyPressed(KeyEvent e) {
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
			
			if(key == 'c'){
				this.hero.extendCord();
			}
			System.out.println("repainting");
			System.out.println(world.getScore());
			frame.remove(frame.getScorePanel());
			frame.add(frame.playerPanelComponent(world, world.getLives(), world.getScore()), BorderLayout.NORTH);
			frame.pack();
			frame.repaint();
			frame.revalidate();
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

