package by.samsolution.checker;

import by.samsolution.params.ParamDefinition;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by QuantumCat on 22.06.2017.
 */
public class CheckerCommandTest {


    private String[] argumentsCommand;
    private List<ParamDefinition> paramDefinitionList;
    private CheckerCommand checkerCommand;

    @Before
    public void setCheckerCommand()
    {
            checkerCommand = new Checker();
    }

    public void setArgumentsCommand() {
        argumentsCommand = new String[2];
        argumentsCommand[0]="find";
        argumentsCommand[1]="--name=somename";
    }

    public void setParamDefinitionList() {
        paramDefinitionList=new ArrayList<ParamDefinition>();
        paramDefinitionList.add(new ParamDefinition("name"));
        paramDefinitionList.add(new ParamDefinition("filename",false));
        paramDefinitionList.add(new ParamDefinition("dirname",false));
    }

    @Test(expected = NullPointerException.class)
    public void itNullPointerExceptionIfArgsIsEmpty()
    {
        setParamDefinitionList();
        assertTrue(checkerCommand.execute(argumentsCommand,paramDefinitionList));
    }

    @Test(expected = NullPointerException.class)
    public void itNullPointerExceptionIfParamDefinitionListIsNull()
    {
        setArgumentsCommand();
        assertTrue(checkerCommand.execute(argumentsCommand,paramDefinitionList));
    }

    @Test
    public void testEqualsMandatoryArguments()
    {
        setParamDefinitionList();
        Checker checker =new Checker();
        assertEquals(checker.mandatoryArgumentsCounter(paramDefinitionList),1);
    }

    @Test
    public void testEqualsMandatoryArgumentsInCommandArguments()
    {
        setParamDefinitionList();
        setArgumentsCommand();
        Checker checker =new Checker();
        assertEquals(checker.countMandatoryParamsInArguments(argumentsCommand,paramDefinitionList),1);
    }

    @Test
    public void ifDuplicationArgumentsGoToCommandFromCommandLine()
    {
        setParamDefinitionList();
        setArgumentsCommand();
        Checker checker =new Checker();
        assertFalse(checker.isDuplicationArguments(argumentsCommand,paramDefinitionList));
    }

    @Test
    public void ifGoArgumentsWhichDoNotBelongCommand()
    {
        setParamDefinitionList();
        setArgumentsCommand();
        Checker checker =new Checker();
        assertFalse(checker.isAnotherArguments(argumentsCommand,paramDefinitionList));
    }

    @Test
    public void execute() throws Exception {
        setArgumentsCommand();
        setParamDefinitionList();
        if(argumentsCommand!=null && paramDefinitionList!=null){
        assertTrue(checkerCommand.execute(argumentsCommand, paramDefinitionList));}
        else
        {
            fail("Аргументы не инициализированы");
        }
    }

}