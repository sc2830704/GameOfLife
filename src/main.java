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
						   
		
		for(int i=0;i<100;i++)
		{
			
			map.show(cre.creature);					  //�L�X�a�ϸ�T
			System.out.printf("�ثe����"+i+"�@�N\n");
			cre.revolution();						  //�i��@�ӥ@�N�c�l			
			Thread.sleep(1000);
			System.out.println("");
		}
			
			
			
		
	}
	
	
}


