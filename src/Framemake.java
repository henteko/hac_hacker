
import javax.swing.JFrame;

public class Framemake extends JFrame{
	
	//�R���X�g���N�^
	Framemake(String title,int x,int y,int w, int h) {
		setTitle(title);
	    setBounds(x, y, w, h);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
