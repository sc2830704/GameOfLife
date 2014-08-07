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
						   
		
		for(int i=0;i<100;i++)
		{
			
			map.show(cre.creature);					  //印出地圖資訊
			System.out.printf("目前為第"+i+"世代\n");
			cre.revolution();						  //進行一個世代繁衍			
			Thread.sleep(1000);
			System.out.println("");
		}
			
			
			
		
	}
	
	
}


