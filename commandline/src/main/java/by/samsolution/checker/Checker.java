package by.samsolution.checker;

import by.samsolution.params.ParamDefinition;

import java.util.List;

/**
 * Created by QuantumCat on 22.06.2017.
 */
public class Checker implements CheckerCommand{
    public boolean execute(String[] argumentsCommand, List<ParamDefinition> paramDefinitionList) {
        if(countMandatoryParamsInArguments(argumentsCommand,paramDefinitionList)==mandatoryArgumentsCounter(paramDefinitionList) &&
                !isAnotherArguments(argumentsCommand,paramDefinitionList) && !isDuplicationArguments(argumentsCommand,paramDefinitionList))
        {
            return true;
        }
        return false;
    }

    public int mandatoryArgumentsCounter(List<ParamDefinition> paramDefinitionList)
    {
        int counter=0;
        for(ParamDefinition paramDefinition:paramDefinitionList)
        {
            if(paramDefinition.getIsMandatory())
            {
                counter++;
            }
        }
        return counter;
    }

    public int countMandatoryParamsInArguments(String[] argumentsCommand, List<ParamDefinition> paramDefinitionList)
    {
        int counter =0;
        for(int i=1; i<argumentsCommand.length;i++)
        {
            for(ParamDefinition paramDefinition: paramDefinitionList)
            {
                if(argumentsCommand[i].contains(paramDefinition.getName()) && paramDefinition.getIsMandatory())
                {
                    counter++;
                }
            }
        }
        return counter;
    }

    public boolean isAnotherArguments(String[] argumentsCommand, List<ParamDefinition> paramDefinitionList)
    {
        for(int i=1; i< argumentsCommand.length;i++)
        {
            int counter=0;
            for(ParamDefinition paramDefinition:paramDefinitionList)
            {
                if(argumentsCommand[i].contains(paramDefinition.getName()))
                {
                    counter++;
                }
            }
            if(counter==0)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicationArguments(String[] argumentsCommand, List<ParamDefinition> paramDefinitionList)
    {
        for(ParamDefinition paramDefinition:paramDefinitionList)
        {
            int counter=0;
            for(int i=1;i<argumentsCommand.length;i++)
            {
                if(argumentsCommand[i].contains(paramDefinition.getName()))
                {
                    counter++;
                }
            }
            if(counter>1)
            {
                System.err.println("Замечено дублирование параметров");
                return true;
            }
        }
        return false;
    }

}
