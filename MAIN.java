import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MAIN extends JFrame {

	public static void main(String[] args) {
	//	new draw().setVisible(true);
	Snake s = new Snake();
		JFrame frame = new JFrame();
		draw ky = new draw();
		ky.setFocusable(true);
		ky.addKeyListener(new KeyBindings(ky));
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.getContentPane().add(ky);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
}
