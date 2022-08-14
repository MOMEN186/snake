import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Snake implements  superc  {
	
	boolean up = false  , down = false , right = true , left = false   , stop=false;
	
	ArrayList<square> arr;
	int score=0 , parts=3  ;
	
	Snake(){
		
		arr = new ArrayList<square>();
	
	}
	
	@Override
	public void move() {
		
		if(up == true) {
		//	down=false;
			up();
			
		}
		else if(down == true) {
	//	up = false;
			down();
		}
		
		else if( right == true ) {
			right();
		}
		
		else if (left == true){
			//right = false;
			left();
		}
		else if (stop == true) {
			
			stop();
		}
		
	}
	public void left() { 
		int n = arr.size()-1;
		for(int i = n; i > 0; i--) {
			int tx, ty;
			tx = arr.get(i-1).x;
			ty = arr.get(i-1).y;
			arr.get(i).x = tx;
			arr.get(i).y = ty;
		}
		arr.get(0).x -= 28;

		
	}
	public void right() {
	System.out.println("RIGHT==TRUE");
		int n = arr.size()-1;
		for(int i = n; i > 0; i--) {
			System.out.println("Right LOOP in");
			int tx, ty;
			tx = arr.get(i-1).x;
			ty = arr.get(i-1).y;
			arr.get(i).x = tx;
			arr.get(i).y = ty;
			System.out.println("right loop");
		}
		System.out.println("AFTER RIGHT LOOP");
		arr.get(0).x += 25;
		
	}
	
	public void up() {
		int n = arr.size()-1;
		for (int i = 0; i <n; i++) {
			System.out.println( i + " " + arr.get(i).x);
			System.out.println( i + " " + arr.get(i).y);
		}
		
		for(int i = n; i > 0; i--) {
			int tx, ty;
			tx = arr.get(i-1).x;
			ty = arr.get(i-1).y;
			arr.get(i).x = tx;
			arr.get(i).y = ty;
		}
		arr.get(0).y -= 28;
		
		/*for (int i = 0; i < 3; i++) {
			System.out.println( i + " " + arr.get(i).x);
			System.out.println( i + " " + arr.get(i).y);*/
		}
		
	
	public void down() {
		int n = arr.size()-1;
		for(int i = n; i > 0; i--) {
			int tx, ty;
			tx = arr.get(i-1).x;
			ty = arr.get(i-1).y;
			arr.get(i).x = tx;
			arr.get(i).y = ty;
		}
		arr.get(0).y+=28;

	}
	
	public void stop() {
	
		}
	
	
	
	public void actionPerformed() {
	
		 if (arr.get(0).x<0 ||arr.get(0).x>500||arr.get(0).y<0||arr.get(0).y>500) {
		stop = true;
		stop();
		 }
	}
	
	public void gameover (Graphics g) {
		stop();
		g.setColor(Color.RED);
		g.setFont((new Font("Century" , Font.BOLD,40)));
		@SuppressWarnings("unused")
		FontMetrics metrics =  g.getFontMetrics();
		g.drawString("Game Over",150, 250);
		
		g.setColor(Color.DARK_GRAY);
		FontMetrics metrics2 =  g.getFontMetrics(g.getFont());
		g.drawString("Press Space to Play",50, 150);
		 
		g.setColor(Color.blue);
		g.setFont((new Font("Century" , Font.BOLD,40)));
		g.drawString("Score"+score,160, 50);
		
		
	}
	
	public void add() {
		int n =arr.size();
		System.out.println(score);
			square sq	= new square(250, 250-25);
			arr.add(0,sq);
			if(down==true) {
				arr.get(0).x=arr.get(1).x;
				arr.get(0).y = arr.get(1).y+25;
			}
			else if (up==true) {
			arr.get(0).x=arr.get(1).x;
			arr.get(0).y = arr.get(1).y-25;
			}
			else if (right==true) {
				arr.get(0).x=arr.get(1).x+25;
				arr.get(0).y = arr.get(1).y;
			}
			else if (left==true){
				arr.get(0).x=arr.get(1).x-25;
				arr.get(0).y = arr.get(1).y;
			}}
			
}
	
	
