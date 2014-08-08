/********************************************************************
FileName    	 main.java
PackageName	 	 
JavaProjectName	 GameOfLife
Synopsis		 Simulate Creature Life
Author			 Rao,Zhi-Hong
Copyright		 SKY(c) all rights reserve, Java, NTUST, TAIWAN, 2014 
********************************************************************/
public class main 
{
	public static void main(String[] args) throws InterruptedException
	{    
		
		Map map =new Map();
		map.initial();								//��l�Ʀa�ϸ�T
		Creature cre=new Creature(map.creature);   //new�@��cre�N��l�ƪ��ͪ���T�ǤJcre
		
		map.show(cre.creature,0);	
		for(int i=1;i<100;i++)
		{
			
			cre.revolution();						  //�i��@�ӥ@�N�c�l	
			map.show(cre.creature,i);					  //�L�X�a�ϸ�T
			Thread.sleep(1000);
			System.out.println("");
		}
			
			
			
		
	}
	
	
}


