package br.com.caelum.vraptor.tasks.callback;

import java.util.List;

import org.quartz.JobExecutionException;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.tasks.Task;
import br.com.caelum.vraptor.tasks.TaskStatistics;

@Component
@ApplicationScoped
public class TaskEventNotifier {
	
	private final List<TaskCallback> listeners;

	public TaskEventNotifier(List<TaskCallback> listeners) {
		this.listeners = listeners;
	}
	
	public void notifyScheduledEvent(Task task){
		for(TaskCallback listener : listeners){
			listener.scheduled(task);
		}
	}

	public void notifyUnscheduledEvent(Task task){
		for(TaskCallback listener : listeners){
			listener.unscheduled(task);
		}
	}
	
	public void notifyBeforeExecuteEvent(Class<? extends Task> task){
		for(TaskCallback listener : listeners){
			listener.beforeExecute(task);
		}
	}
	
	public void notifyExecutionVetoedEvent(Class<? extends Task> task){
		for(TaskCallback listener : listeners){
			listener.executionVetoed(task);
		}
	}
	
	public void notifyExecutedEvent(Class<? extends Task> task, TaskStatistics stats){
		for(TaskCallback listener : listeners){
			listener.executed(task, stats);
		}
	}
	
	public void notifyPausedEvent(Class<? extends Task> task){
		for(TaskCallback listener : listeners){
			listener.paused(task);
		}
	}
	
	public void notifyResumedEvent(Class<? extends Task> task){
		for(TaskCallback listener : listeners){
			listener.resumed(task);
		}
	}

	public void notifyPauseAllEvent() {
		for(TaskCallback listener : listeners){
			listener.pausedAll();
		}
		
	}

	public void notifyResumeAllEvent() {
		for(TaskCallback listener : listeners){
			listener.resumedAll();
		}
	}

	public void notifyFailedEvent(Class<? extends Task> task, TaskStatistics stats, Exception exception) {
		for(TaskCallback listener : listeners){
			listener.failed(task, stats, exception);
		}
	}
}
