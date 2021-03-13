package br.com.engineserver.handlers;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("delegateService")
public class DelegateServiceHandler implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        delegateExecution.setVariable("varFromDelegate", "Hello, there is a new variable");
    }

}
