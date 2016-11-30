package tanMo.gun;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import tanMo.bullet.Bullet;
import tanMo.target.Target;

import java.util.TimerTask;
import java.util.Timer;

public class Gun 
{
	private Direct direct;
	private int Y;
	private Bullet bullet=null;
	private int speed;
	private int interval;
	
	public Gun() 
	{
		direct=Direct.LEFT;
		speed=30;
		Y=0;
		interval=4;
	}
	
	public Gun(Direct D,int position)
	{
		direct=D;
		Y=position>0 ? position:0;
		speed=30;
		interval=4;
	}
	
	public Gun(Direct D,int position,int s,int i)
	{
		direct=D;
		Y=position>0 ? position:0;
		speed=s>0? s:30;
		interval=i>0? i:4;
	}
	
	public void setSpeed(int s) 
	{
		speed=s>0? s:speed;
	}
	
	public void setInterval(int i)
	{
		interval=i>0? i:interval;
	}
	
	public int getY() 
	{
		return Y;
	}
	
	public Direct getDirect() 
	{
		return direct;
	}
	
	public void setDirect(Direct direct) 
	{
		this.direct = direct;
	}
	
	public void setY(int y) 
	{
		if(y>=0)Y=y;
	}
	
	public void loadBullet(Bullet b) 
	{
		bullet=b;
	}
	
	public void shoot(Target target)
	{
		//假如沒有子彈 返回
		if(bullet==null) return;
		
		//製作jlabel子彈
		JLabel label=new JLabel(bullet.getContent());
		if(bullet.getFont()!=null)//設定字形
		{
			label.setFont(bullet.getFont());
		}else
		{
			label.setFont(new Font("新細明體", Font.PLAIN, bullet.getSize()));
		}
		label.setForeground(bullet.getColor());
		
		int textwidth=label.getFontMetrics(label.getFont()).stringWidth(label.getText());//獲得字串長度
		int startX= (direct==Direct.LEFT) ? target.getwidth():-textwidth;//獲得起始位子
		label.setBounds(startX, Y,textwidth,label.getFont().getSize());//設定起始位子
		//製作完成
		
		target.addInPanel(label);;//將jlable放到target
		SwingUtilities.invokeLater(new Runnable() //設定飛行時間
		{
			public void run() 
			{
				Timer timer=new Timer();
				timer.schedule(getTimetask(label, startX, target.getwidth(), timer,target), 0,speed);
			}
		});
		
	}
	
	private TimerTask getTimetask(JLabel label,int startX,int width,Timer t,Target tar) 
	{
		TimerTask timerTask=null;
		int dis=label.getFontMetrics(label.getFont()).stringWidth(label.getText());
		timerTask=new TimerTask()
		{			
			Timer timer=t;
			int start=startX;
			int distance=width+dis;
			int move=0;
			JLabel lb=label;
			Target target=tar;
			@Override
			public void run() 
			{
				if(move<distance)
				{
					move+=interval;
					lbChangeLocation(start, move, lb);
				}else 
				{
					timer.cancel();
					target.getContentPane().remove(label);
				}
				target.refresh();
			}
		};
		
		return timerTask;
	}
	
	private void lbChangeLocation(int start,int move,JLabel lb)
	{
		if(direct==Direct.LEFT)
			lb.setLocation(start-move,Y);
		else
			lb.setLocation(start+move,Y);
	}
}


