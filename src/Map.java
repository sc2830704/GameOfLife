/********************************************************************
FileName    	 Map.java
PackageName	 	 
JavaProjectName	 GameOfLife
Synopsis		 Initial map and Show map situation
Author			 Rao,Zhi-Hong
Copyright		 SKY(c) all rights reserve, Java, NTUST, TAIWAN, 2014 
********************************************************************/
import java.util.Random;


public class Map 
{
	private final int CREATURE_NUMBER=450;		//生物數量
	final static int BORDER=30;					//邊界大小
    int[][] creature=new int[BORDER][BORDER];
	int AllCreNum;
	
	
	public void initial()    //初始化生物分部
	{
		Random rand=new Random();
		int r,c,flag=0;
		while(flag<CREATURE_NUMBER)			//設定flag計算隨機生成的生物數量，當達到時離開迴圈
		{
			r=rand.nextInt(BORDER);
			c=rand.nextInt(BORDER);
			if(creature[r][c]==0)
			{	
				creature[r][c]=1;
				flag++;
			}
			
		}
	}
	public void show(int[][] a)
	{
		AllCreNum=0;
		for(int r=0;r<creature.length;r++)
		{
			for(int c=0;c<creature[r].length;c++)
			{
				if(creature[r][c]==1||creature[r][c]==3)
				{
					System.out.printf("@");
					AllCreNum++;
				}
				else
				System.out.printf("-");	
			}
			System.out.println("");
		}
	System.out.printf("生物數量:"+AllCreNum);	
	}
	
}


