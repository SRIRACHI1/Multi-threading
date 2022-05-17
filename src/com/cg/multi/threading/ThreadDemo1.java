package com.cg.multi.threading;

class Source
{
	String[] names = { "abc","vvvv","adss"};
}

class A implements Runnable
{

	Source source;
	Thread t;
	A()
	{
		t=new Thread(this,"ONE");
		t.start();
	}
	@Override
	public void run() {
		
		source = new  Source();
		for(int i=0;i<source.names.length;i++)
		{
			System.out.println(t.getName()+" "+t.getPriority()+" "+"printing"+source.names[i]);
		}
	
		
	}
	
}
public class ThreadDemo1 {
	public static void main(String[] args) throws InterruptedException {
		Source source = new Source();
		//source.names.
		A a = new A();
		
		for(int i =0;i<source.names.length;i++)
		{
			Thread.sleep(100);
			System.out.println(Thread.currentThread()+" "+" printing"+source.names[i]);
		}
	}

}