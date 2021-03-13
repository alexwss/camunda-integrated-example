package br.com.externalcalc.externalcalcservice.handler;

import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

@Component("topic_calc")
public class CalcHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        externalTaskService.handleBpmnError(externalTask, "CALC_ERROR", "CALC_ERROR");
    }

}
