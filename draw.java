import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import java.util.Random;
@SuppressWarnings("serial")
public class draw extends JPanel     {
	
	public Snake snake;
	int applex ,appley ;
	int sum=0 , start=0;
	int unitsize=25;
	int subx , suby , scollx , scolly;
	
	square sq ;
	
	draw(){
		
		snake = new Snake();
		
		for(int i=snake.parts; i>0;i--) {
		 sq = new square(250, 250-25*i);
			snake.arr.add(sq);
			
		}
		/*for (int i = 0; i < parts; i++) {
			System.out.println( i + " x:" + snake.arr.get(i).x);
			System.out.println( i + " y:" + snake.arr.get(i).y);*/
		}
		
	
	
	@Override
	public void paint( Graphics g ) { 
		System.out.println("paint");
		super.paint(g);
		g.setColor(Color.red);
		
		snake.move();
		
		//Drawing the Snake
		
		collision();
		for(int i=0; i<snake.parts; i++){
			g.fillRect(snake.arr.get(i).x ,snake.arr.get(i).y, 15, 15);
			
		}
			
	  	try {
			TimeUnit.MILLISECONDS.sleep(85);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		snake.actionPerformed();
		if (snake.stop==true) {
			snake.gameover(g);
			return;
		}
		//g.fillRect(applex, appley,15, 15);
		g.setColor(Color.magenta);
		g.fillOval(applex, appley, 15, 15);
		FontMetrics metrics3 =  g.getFontMetrics(g.getFont());
		g.setColor(Color.blue);
		g.setFont((new Font("Century" , Font.BOLD,40)));
		g.drawString("Score"+snake.score,120, 30);
		repaint();
		
		
	}

	Random random = new Random();
	public void newapple() {
		applex = random.nextInt(470);
		System.out.println("code generated"+applex);
		appley = random.nextInt(250);
	}
	
	public void collision(){
		 subx = snake.arr.get(0).x-applex;
		 suby = snake.arr.get(0).y-appley;
		
		if(	Math.abs(subx)<15 && Math.abs(suby) <15){
			sum++;
			System.out.println("collides "+ sum);
			snake.score++;
			snake.parts++;
			snake.add();
		}
		 
		  if(sum> 0|| start==0) { 
		  sum=0;
			newapple();			
		  start++; 
		 // snake.add();
		}
		  
		  int n = snake.arr.size()-1;
		   
		  for(int i=n;i>0;i--) {
			  scollx =snake.arr.get(0).x - snake.arr.get(i).x;
			  scolly = snake.arr.get(0).y - snake.arr.get(i).y;
			  
			  if(Math.abs(scollx)<15 && Math.abs(scolly)<15) {
				  snake.stop=true;
			
			  }
			  	
		  }
	}
	
	}
	


