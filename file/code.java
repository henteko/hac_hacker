import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class main {

	public static ArrayList<Framemake> frame = new ArrayList<Framemake>();

	public static int Read_Line = 0;

	public static int Connect_win = 0;
	public static int Connect_fail = 0;
	
	public static String[] File_name = {"file/main.java","file/command.txt"};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		frame_make(1);
	}

	public static void frame_make(final int id) {

		// ランダム生成
		Random random = new Random();

		int x, y, w, h;
		do {
			x = random.nextInt(500);
		} while (x < 0);
		do {
			y = random.nextInt(500);
		} while (y < 0);
		do {
			w = random.nextInt(600);
		} while (w < 400);
		do {
			h = random.nextInt(600);
		} while (h < 100);
		frame.add(new Framemake("hac_hacker", x, y, w, h));

		final TextArea b1 = new TextArea("", 3, 20);

		b1.setForeground(Color.GREEN);
		b1.setBackground(Color.BLACK);
		b1.setEditable(false);
		b1.setMaximumSize(b1.getPreferredSize());
		b1.setMinimumSize(b1.getPreferredSize());

		b1.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				// キーボードが押されたときの処理
				System.out.println(e);
				if (e.getKeyCode() == 17) {
					// コントロールが押されたら
					frame_make(id + 1);
					Read_Line = 0;
					Connect_win = 0;
					Connect_fail = 0;
				} else if (e.getKeyCode() == 9) {
					// タブを押した時
					Connect_win++;
					Connect_fail = 0;
					if (Connect_win == 3) {
						// 通信成功
						Framemake Last = new Framemake("hac_hacker", 200, 200, 300, 100);
						Last.setLocationRelativeTo(null);
						final TextArea Last_b = new TextArea("", 3, 20);

						Last_b.setForeground(Color.GREEN);
						Last_b.setBackground(Color.BLACK);
						Last_b.setEditable(false);
						Last_b.insert("Connect Done!!\n", Last_b.getCaretPosition());
						
						Last.add(Last_b);
						Last.setVisible(true);
					}
				} else if (e.getKeyCode() == 16) {
					// シフトを押した時
					Connect_fail++;
					Connect_win = 0;
					if (Connect_fail == 3) {
						// 通信失敗
						Framemake Last = new Framemake("hac_hacker", 200, 200, 300, 100);
						Last.setLocationRelativeTo(null);
						final TextArea Last_b = new TextArea("", 3, 20);

						Last_b.setForeground(Color.GREEN);
						Last_b.setBackground(Color.BLACK);
						Last_b.setEditable(false);
						Last_b.insert("Connect Failure!!\n", Last_b.getCaretPosition());
						
						Last.add(Last_b);
						Last.setVisible(true);
					}
				}else {
					Connect_win = 0;
					Connect_fail = 0;
					try {
						FileReader f = new FileReader(File_name[0]);
						BufferedReader b = new BufferedReader(f);
						String s;
						int i = 0;
						while ((s = b.readLine()) != null) {

							if (i == Read_Line + 1) {
								b1.insert(s + "\n", b1.getCaretPosition());
								Read_Line++;
								break;
							}
							i++;
						}
					} catch (Exception e1) {
						System.out.println("ファイル読み込み失敗");
					}
				}
			}

			public void keyReleased(KeyEvent e) {
				// キーボードが離されたときの処理
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		frame.get(id - 1).add(b1);
		frame.get(id - 1).setVisible(true);
	}

}
