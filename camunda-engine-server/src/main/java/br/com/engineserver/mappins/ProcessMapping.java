package br.com.engineserver.mappins;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

@Component("processMapping")
public class ProcessMapping  implements DelegateVariableMapping {
    @Override
    public void mapInputVariables(DelegateExecution delegateExecution, VariableMap variableMap) {

    }

    @Override
    public void mapOutputVariables(DelegateExecution delegateExecution, VariableScope variableScope) {

    }
}
