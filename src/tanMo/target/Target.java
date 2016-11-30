package tanMo.target;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Target extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x=0;
	private int y=0;
	private int width=0;
	private int height=0;
	double screenX=0;
	double screenY=0;
   	private static Target target=null;
   	private JFrame frame=null;
	
   	private Target()
   	{
   		frame=new JFrame();
   		screenX=getToolkit().getScreenSize().getWidth();
   		screenY=getToolkit().getScreenSize().getHeight();
   		this.setBounds(x, y, (int)screenX, (int)screenY);
   		width=(int)screenX;
   		height=(int)screenY;
   		frame.setUndecorated(true);
   		frame.getContentPane().setLayout(null);
   		frame.setBackground(new Color(255, 255, 255, 0));
   		frame.getContentPane().setBackground(new Color(255,255,255,0));
   		frame.setAlwaysOnTop(true);
   		frame.setType(Type.UTILITY);
   		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
   	}
   	
   	static public Target CreateTarget()
   	{
   		if(target!=null)return target;
   		else
   		{
   			target=new Target();
   			return target;
		}
   	}
   	
   	@Override
   	public void setBounds(int newx,int newy,int newWidth,int newHeight)throws IllegalArgumentException
   	{
   		if(newx<0||newy<0||newWidth<0||newHeight<0)throw new IllegalArgumentException();
   		
   		x=newx;
   		y=newy;
   		width=newWidth;
   		height=newHeight;
   		frame.setBounds(newx, newy, newWidth, newHeight);
   	}
   
   	
   	public void refresh() 
   	{
   		frame.revalidate();
   		frame.repaint();
	}
   	
   	
    public void CloseTarget() 
   	{
   		target=null;
   		frame.setVisible(false);
   		frame.dispose();
	}
    
    public void addInPanel(JLabel l)
    {
    	frame.getContentPane().add(l);
    }
    
    public void setVisible(boolean b) 
    {
    	frame.setVisible(b);
	}
    
    public int getx() 
    {
		return x;
	}
    
    public int gety() 
    {
		return y;
	}
    
    public int getwidth() 
    {
		return width;
	}
    
    public int getheight() 
    {
		return height;
	}
}
