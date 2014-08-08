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
		map.initial();								//初始化地圖資訊
		Creature cre=new Creature(map.creature);   //new一個cre將初始化的生物資訊傳入cre
		
		map.show(cre.creature,0);	
		for(int i=1;i<100;i++)
		{
			
			cre.revolution();						  //進行一個世代繁衍	
			map.show(cre.creature,i);					  //印出地圖資訊
			Thread.sleep(1000);
			System.out.println("");
		}
			
			
			
		
	}
	
	
}


