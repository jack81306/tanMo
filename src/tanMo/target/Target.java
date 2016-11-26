package tanMo.target;

import java.awt.Color;

import javax.swing.JFrame;

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
	
   	private Target()
   	{
   		screenX=getToolkit().getScreenSize().getWidth();
   		screenY=getToolkit().getScreenSize().getHeight();
   		this.setBounds(x, y, (int)screenX, (int)screenY);
   		width=(int)screenX;
   		height=(int)screenY;
   		this.setUndecorated(true);
   		this.getContentPane().setLayout(null);
   		this.setBackground(new Color(255, 255, 255, 0));
   		this.getContentPane().setBackground(new Color(255,255,255,0));
   		this.setAlwaysOnTop(true);
   		this.setType(Type.UTILITY);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
   		super.setBounds(newx, newy, newWidth, newHeight);
   	}
   
   	
   	public void refresh() 
   	{
   		this.revalidate();
   		this.repaint();
	}
   	
   	
    public void CloseTarget() 
   	{
   		target=null;
   		this.setVisible(false);
   		this.dispose();
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
