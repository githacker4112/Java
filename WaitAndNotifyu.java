package MultiThreading;

class Bank
{
	int ac_no=1111;
	int balance=0;
		synchronized public void withdrawl(int w_amt) throws InterruptedException
	{
			while(w_amt>balance)
			{	System.out.println("Insufficient Balance");
				System.out.println("Thread is in Waiting Sate");
				wait();
			}
				balance=balance-w_amt;
				System.out.println("Amount "+w_amt+" is debited from you acc"+ac_no);
				System.out.println("And Remaing balance is "+balance);
			}
	
	
	
	synchronized public void deposite(int dept_amt)
	{
		balance=balance+dept_amt;
		System.out.println("Money "+dept_amt+" is credited in your ac"+ac_no);
		notify();
		
	}
}
class Th1 extends Thread
{
	Bank b;
	Th1(Bank b)
	{
		this.b=b;
	}

		public void run()
	{
		
		try {
			b.withdrawl(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}


class Th2 extends Thread
{
	Bank b;
	Th2(Bank b)
	{
		this.b=b;
	}

	public void run()
	{

		b.deposite(10000);
		
	}

}

public class WaitAndNotify {
public static void main(String[] args) throws InterruptedException {

	Bank b=new Bank();
	Th1 t1=new Th1(b);
	t1.start();
	Thread.sleep(1000);
	Th2 t2=new Th2(b);
	t2.start();
}
}
