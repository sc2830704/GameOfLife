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
	int[][] creature;			//��N�ͪ���T
	int[][] creatureTmp = new int[Map.BORDER][Map.BORDER];	//�U�@�N�ͪ���T
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
	
	
	private int liveNum(int r,int c,int border,int[][] creature)   //�ǤJ�}�C���ޡB��ɪ��B��N�ͪ���T�A�P�_����ͪ��ƶq
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
		while(flag==0)		//�P�_�ͦ��ͪ�:�ͦ����}�j��A���ѭ���
		{
			R=rand.nextInt(3)-1;			//�üƱoR=-1~1	
			C=rand.nextInt(3)-1;			//�üƱoC=-1~1
			
			if(r+R>=0 && r+R<=border && c+C>=0 && c+C<=border && creature[r+R][c+C]==0 && creatureTmp[r+R][c+C]==0)
			//��ɤ��A�ӥ@�N�L�ͪ����I�B�U�@�@�N�L�ͪ��ͦ����I�ͦ��s�ͪ�
			{
				creatureTmp[r+R][c+C]=1;        
				flag++;
			}
			
		}
		
	}
	
	public void revolution()  
	//1.���P�_�U�ӥ@�N�|�������ͪ�    �W�h:����ͪ��ƶq>=3 
	//2.�A�P�_�|�ͦ��s�ͪ����I           �W�h:�ӥ@�N����ͪ��ƶq=1�A�ͦ����I���ӥ@�N�S���ͪ����I
	{						
		die=0;
		born=0;
		for(int r=0;r<creature.length;r++)			//1.	
		{
			for(int c=0;c<creature[r].length;c++)
			{
					if( (liveNum(r,c,Map.BORDER-1,creature)>=3)  && creature[r][c]==1 )		//�P�_����ͪ��ƶq�A�p�G�j��3�h�ӥͪ����`�AcreTmp�]��0
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
				if( (liveNum(r,c,Map.BORDER-1,creature)==1) && creature[r][c]==1 )		//�P�_����ͪ��ƶq�A�p�G����1�h�c�l
				{
					grow(r,c,Map.BORDER-1);	
					born++;
				}
				
			}
		}	

		
		for(int r=0;r<creature.length;r++)				//�N�Ȧs���ͪ���T�ƻs�^creature[][]�A
		{
			for(int c=0;c<creature[r].length;c++)
			{
						creature[r][c]=creatureTmp[r][c];           
			}
		}
		
		
	}

	
	
}





