package ua.lviv.igs;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import ua.lviv.igs.Seance;
import ua.lviv.igs.Time;

public class MyTest {

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED --> "+ description.getMethodName());
		};
		
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED --> "+ description.getMethodName());
		};
	};
	
	@Test
	public void TimeTest1() throws TimeException{
		new Time(10,10);
	}
	
	@Test
	public void TimeTest2() throws TimeException{
		new Time(10,65);
	}
	
	@Test (expected = TimeException.class)
	public void TimeTest3() throws TimeException{
		 new Time(10,65);
	}
	
	@Test
	public void AddEndTimeTest1() throws TimeException {
		Time real = Seance.addEndTime(new Time(10,10), new Time(10,10));
		Time expected = new Time(20,20);
		Assert.assertEquals(expected, real);
	}
	
	
	
	
	
	
	
	
	
	
}
