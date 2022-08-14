
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class KeyBindings extends JFrame implements KeyListener  {
	
	
	private draw d;
	
	public KeyBindings(draw d) {
		this.d=d;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT ) {
			if(d.snake.right==false) {
			d.snake.left=true;
			d.snake.up=false;
			d.snake.down=false;
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(d.snake.left==false) {
			d.snake.right=true;
			d.snake.up=false;
			d.snake.down=false;
			}
		}
		
		else if(e.getKeyCode()==KeyEvent.VK_UP) {
			
			if(d.snake.down==false) {
			d.snake.up=true;
			d.snake.left=false;
			d.snake.right=false;
			}
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(d.snake.up==false) {
			d.snake.down=true;
			d.snake.right=false;
			d.snake.left=false;
			
			}
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_SPACE && d.snake.stop == true) {
			System.out.println("gggg");
		
			d.start=0;
			d.snake.score=0;
			d.snake.stop = false;
			d.snake= new Snake();
			d.snake.parts=3;
			for(int i=d.snake.parts; i>0;i--) {
				System.out.println("NEw SNAKE");
				square sq = new square(250, 250-25*i);
				  d.snake.arr.add(sq);
			}
			
			d.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}


