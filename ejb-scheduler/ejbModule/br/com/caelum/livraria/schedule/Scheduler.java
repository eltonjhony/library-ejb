package br.com.caelum.livraria.schedule;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class Scheduler {

	@Schedule(hour="*",minute="*", second="*/10")
	public void sheduler() {
		System.out.println("Periodically checked service");
	}
}
