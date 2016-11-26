package tanMo.bullet;

import java.awt.Color;
import java.awt.Font;

public class Bullet 
{
	private Color color;
	private int size;
	String content;
	Font font=null;
	
	public Bullet() 
	{
		this(new Color(0, 0, 0), 0, "");
	}
	
	public Bullet(Color c,int s,String str)
	{
		color=c;
		size= s>=0? s:0;
		content=str;
	}
	
	public Color getColor() 
	{
		return color;
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public String getContent() 
	{
		return content;
	}
	
	public Font getFont() 
	{
		return font;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public void setSize(int s)
	{
		size= s>=0? s:0;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public void setFont(Font font) 
	{
		this.font = font;
	}
}
