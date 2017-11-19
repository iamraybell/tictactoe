import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements ActionListener{
	public static final int WIDTH = 700;
	public static final int HEIGHT =700;
	public Player p1;
	public Player p2;
	public Player curPlayer;
	public static JMenuItem reset;
	public  JButton b1;
	public  JButton b2;
	public  JButton b3;
	public  JButton b4;
	public  JButton b5;
	public  JButton b6;
	public  JButton b7;
	public  JButton b8;
	public  JButton b9;
	private int total = 0;
	private Line r1;
	private Line r2;
	private Line r3;
	private Line c1;
	private Line c2;
	private Line c3;
	private Line d1;
	private Line d2;

public class Line{
	public int x;
	public int o;
	public Line(){
		this.o = 0;
		this.x = 0;
	}

	private boolean addCounter(String choice,Boolean status){
	System.out.println("running...");
		
		if(choice == "X"){
			this.x +=1;
		}else{
			this.o +=1;
		}
		System.out.println(this.x);
		System.out.println(this.o);
		if(this.x >2 ){

			return true;
		}
		if(this.o >2 ){

			return true;
		}
		if(status){
			return true;
		}
		return false;
		}

}
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if(source == this.reset){
			this.clear();
			return;
		}
		this.total +=1;
      	JButton btn = (JButton)source;
      	String nextLetter = this.curPlayer.letter;
      	Boolean winStatus = false;
        if(btn.getText() == ""){
        	if(btn ==this.b1){
				System.out.println("1111111 start");	
        		winStatus = this.r1.addCounter(nextLetter,winStatus);
        		winStatus = this.d1.addCounter(nextLetter,winStatus);
        		winStatus = this.c1.addCounter(nextLetter,winStatus);
        		System.out.println("end");

        	}
        	if(btn ==this.b2){
        		System.out.println("22222");
        		winStatus = this.r1.addCounter(nextLetter,winStatus);
        		winStatus = this.c2.addCounter(nextLetter,winStatus);
        	}
        	if(btn ==this.b3){

        		System.out.println("33333333333");
        		winStatus = this.r1.addCounter(nextLetter,winStatus);
        		winStatus = this.d2.addCounter(nextLetter,winStatus);
        		winStatus = this.c3.addCounter(nextLetter,winStatus);
        	}
        	if(btn ==this.b4){
        		System.out.println("444444444444444****");
        		winStatus = this.r2.addCounter(nextLetter,winStatus);
        		winStatus = this.c1.addCounter(nextLetter,winStatus);	
        	}
        	if(btn ==this.b5){
        	System.out.println("555555555555555");
        	    winStatus = this.r2.addCounter(nextLetter,winStatus);
        	    winStatus = this.d1.addCounter(nextLetter,winStatus);
        	    winStatus = this.c2.addCounter(nextLetter,winStatus);
        	    winStatus = this.d2.addCounter(nextLetter,winStatus);	
        	}
        	if(btn ==this.b6){
        		System.out.println("^^^^^^6666666666");
        		winStatus = this.r2.addCounter(nextLetter,winStatus);
        		winStatus = this.c3.addCounter(nextLetter,winStatus);	
        	}
        	if(btn ==this.b7){
        		System.out.println("7777777777777");
        		winStatus = this.r3.addCounter(nextLetter,winStatus);
        		winStatus = this.c1.addCounter(nextLetter,winStatus);
        		winStatus = this.d2.addCounter(nextLetter,winStatus);	
        	}
        	if(btn ==this.b8){
        		System.out.println("888888888888");
        		winStatus = this.r3.addCounter(nextLetter,winStatus);
        		winStatus = this.c2.addCounter(nextLetter,winStatus);	
        	}
        	if(btn ==this.b9){
        		System.out.println("99999999999999");
        		winStatus = this.r3.addCounter(nextLetter,winStatus);
        		winStatus = this.c3.addCounter(nextLetter,winStatus);
        		winStatus = this.d1.addCounter(nextLetter,winStatus);	
        	}
        	btn.setText(nextLetter);
        	if(winStatus){
        		JOptionPane.showMessageDialog(null, "We have a winner.","Winner!!!!",  JOptionPane.WARNING_MESSAGE);
        		this.clear();
        		return;
        	}
        	if(this.total == 9){
        		this.clear();
        		JOptionPane.showMessageDialog(null, "Its a tie. Reset to start a new game.","TIE :(",  JOptionPane.WARNING_MESSAGE);
        		return;
        	}
        	this.togglePlayer();	
        }
	}
	public TicTacToe(){

		super();

		JMenu file =  new JMenu("file");
		this.reset = new JMenuItem("reset");
		this.reset.addActionListener(this);
		file.add(this.reset);
		JMenuBar bar = new JMenuBar();
		bar.add(file);
		setJMenuBar(bar);	
	}
	public void clear(){
		getContentPane().removeAll();
		this.startGame();
		revalidate();
		repaint();
		

	}
	public void startGame(){
		this.total = 0;
		this.r1= new Line();
		this.r2= new Line();
		this.r3= new Line();
		this.c1= new Line();
		this.c2= new Line();
		this.c3= new Line();
		this.d1= new Line();
		this.d2= new Line();
		this.p1 = new Player("X");
		this.p2 = new Player("O");
		this.curPlayer  = p1;
		setSize(WIDTH, HEIGHT);
		setLayout(new GridLayout(3,3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tic Tac Toe!");
		this.b1 = new JButton("");
		this.b1.addActionListener(this);
		this.b1.setFont(new Font("Arial", Font.BOLD, 100));
		add(this.b1);
		this.b2 = new JButton("");
		this.b2.addActionListener(this);
		this.b2.setFont(new Font("Arial", Font.BOLD, 100));
		add(this.b2);
		this.b3 = new JButton("");
		this.b3.addActionListener(this);
		this.b3.setFont(new Font("Arial", Font.BOLD, 100));
		add(this.b3);
		this.b4 = new JButton("");
		this.b4.addActionListener(this);
		this.b4.setFont(new Font("Arial", Font.BOLD, 100));
		add(this.b4);
		this.b5 = new JButton("");
		this.b5.addActionListener(this);
		this.b5.setFont(new Font("Arial", Font.BOLD, 100));
		add(this.b5);
		this.b6 = new JButton("");
		this.b6.addActionListener(this);
		this.b6.setFont(new Font("Arial", Font.BOLD, 100));
		add(this.b6);
		this.b7 = new JButton("");
		this.b7.addActionListener(this);
		this.b7.setFont(new Font("Arial", Font.BOLD, 100));
		add(this.b7);
		this.b8 = new JButton("");
		this.b8.addActionListener(this);
		this.b8.setFont(new Font("Arial", Font.BOLD, 100));
		add(this.b8);
		this.b9 = new JButton("");
		this.b9.addActionListener(this);
		this.b9.setFont(new Font("Arial", Font.BOLD, 100));
		add(this.b9);
	}
	public void togglePlayer(){
		if(this.curPlayer == this.p1){
			this.curPlayer = this.p2;
		}else{
			this.curPlayer = this.p1;
		}
	}
	public static void main(String[] args){
		TicTacToe myGame = new TicTacToe();
		myGame.setVisible(true);
		myGame.startGame();

	}

	}



