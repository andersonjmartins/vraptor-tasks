package br.com.caelum.vraptor.tasks.jobs.request;

import java.net.URL;

import br.com.caelum.vraptor.tasks.Task;

public interface RequestScopedTask extends Task {
	
	void setup(URL endpoint);

}