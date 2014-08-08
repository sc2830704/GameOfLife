/********************************************************************
FileName    	 Creature.java
PackageName	 	 
JavaProjectName	 GameOfLife
Synopsis		 About grow, revolution, creature number
Author			 Rao,Zhi-Hong
Copyright		 SKY(c) all rights reserve, Java, NTUST, TAIWAN, 2014 
********************************************************************/
import java.util.Random;

public class Creature 
{
	int[][] creature;			//當代生物資訊
	int[][] creatureTmp = new int[Map.BORDER][Map.BORDER];	//下一代生物資訊
	static int die=0,born=0;
	Random rand = new Random();
	public Creature (int[][] creature)
	{
		this.creature=creature;
		for(int r=0;r<creature.length;r++)
		{
			for(int c=0;c<creature[r].length;c++)
			{
				creatureTmp[r][c]=creature[r][c];
			}
		}	
	}
	
	
	private int liveNum(int r,int c,int border,int[][] creature)   //傳入陣列索引、邊界直、當代生物資訊，判斷附近生物數量
	{
		int creNum=0;
		if(r-1>=0 && c-1>=0 && r-1<=border && c-1<=border && creature[r-1][c-1]==1)
			creNum++;
		if(r-1>=0 && c>=0 && r-1<=border && c<=border && creature[r-1][c]==1)
			creNum++;
		if(r-1>=0 && c+1>=0 && r-1<=border && c+1<=border && creature[r-1][c+1]==1)
			creNum++;
		if(r>=0 && c-1>=0 && r<=border && c-1<=border && creature[r][c-1]==1)
			creNum++;
		if(r>=0 && c+1>=0 && r<=border && c+1<=border && creature[r][c+1]==1)
			creNum++;
		if(r+1>=0 && c-1>=0 && r+1<=border && c-1<=border && creature[r+1][c-1]==1)
			creNum++;
		if(r+1>=0 && c>=0 && r+1<=border && c<=border && creature[r+1][c]==1)
			creNum++;
		if(r+1>=0 && c+1>=0 && r+1<=border && c+1<=border && creature[r+1][c+1]==1)
			creNum++;
		
		return creNum;
	}
	private void grow(int r,int c ,int border)
	{
		int R,C,flag=0;
		while(flag==0)		//判斷生成生物:生成離開迴圈，失敗重複
		{
			R=rand.nextInt(3)-1;			//亂數得R=-1~1	
			C=rand.nextInt(3)-1;			//亂數得C=-1~1
			
			if(r+R>=0 && r+R<=border && c+C>=0 && c+C<=border && creature[r+R][c+C]==0 && creatureTmp[r+R][c+C]==0)
			//邊界內，該世代無生物的點、下一世代無生物生成的點生成新生物
			{
				creatureTmp[r+R][c+C]=1;        
				flag++;
			}
			
		}
		
	}
	
	public void revolution()  
	//1.先判斷下個世代會消失的生物    規則:附近生物數量>=3 
	//2.再判斷會生成新生物的點           規則:該世代附近生物數量=1，生成的點為該世代沒有生物的點
	{						
		die=0;
		born=0;
		for(int r=0;r<creature.length;r++)			//1.	
		{
			for(int c=0;c<creature[r].length;c++)
			{
					if( (liveNum(r,c,Map.BORDER-1,creature)>=3)  && creature[r][c]==1 )		//判斷附近生物數量，如果大於3則該生物死亡，creTmp設為0
					{	
						creatureTmp[r][c]=0;
						die++;
					}
			}
		}	
		for(int r=0;r<creature.length;r++)			//2.
		{
			for(int c=0;c<creature[r].length;c++)
			{
				if( (liveNum(r,c,Map.BORDER-1,creature)==1) && creature[r][c]==1 )		//判斷附近生物數量，如果等於1則繁衍
				{
					grow(r,c,Map.BORDER-1);	
					born++;
				}
				
			}
		}	

		
		for(int r=0;r<creature.length;r++)				//將暫存的生物資訊複製回creature[][]，
		{
			for(int c=0;c<creature[r].length;c++)
			{
						creature[r][c]=creatureTmp[r][c];           
			}
		}
		
		
	}

	
	
}





