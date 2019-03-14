class test {
	int i;
	synchronized public void Odd(){
		for( i=1;i<100;i=i+2)
		{
			try{wait();}
			catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+" : "+i);
			notify();
			}
	}
	synchronized public void Even(){
		for(int i=0;i<100;i=i+2)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
			notify();
			try{wait();}
			catch(Exception e){}
		}
	}
}

class OddThread extends Thread{
	test t=null;
	OddThread(test t)
	{	
		this.t=t;
	}
	public void run()
	{
		t.Odd();
	}
}

class EvenThread extends Thread{
	test t=null;
	EvenThread(test t)
	{  this.t=t;}
	public void run()
	{
		t.Even();
	}
}

public class OddEven{
	public static void main(String args[])
	{
		test t=new test();
		OddThread t1=new OddThread(t);
		EvenThread t2=new EvenThread(t);
		t1.start();
		t2.start();
	}
}
