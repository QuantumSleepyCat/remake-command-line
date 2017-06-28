package by.samsolution.service;

import by.samsolution.commands.Command;
import by.samsolution.commands.definition.CommandDefinition;
import by.samsolution.params.ParamDefinition;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by QuantumCat on 23.06.2017.
 */
public class CommandsServiceTest {
    private Map<String, String> config;
    private CommandDefinition commandDefinition;
    private String[] commandArguments;
    private CommandsService commandsService;
    private Command command =new Command() {
        public void execute(Map<String, String> commandArgumentsMap, String[] commandAguments)  {
            System.out.println(commandAguments[0]);
            System.out.println(commandArgumentsMap.containsKey("name"));
        }
    };

    @Before
    public void setCommandsService()
    {
        commandsService=new CommandsServiceImpl();
    }

    public void setConfig() {
        config = new HashMap<String, String>();
        config.put("filename","students.txt");
        config.put("dirname","stud");
    }

    public void setCommandDefinition() {
        List<ParamDefinition> paramsFind = new ArrayList<ParamDefinition>();
        paramsFind.add(new ParamDefinition("name"));
        paramsFind.add(new ParamDefinition("filename", false));
        paramsFind.add(new ParamDefinition("dirname", false));
        this.commandDefinition =new CommandDefinition("find", command.getClass(), paramsFind);
    }

    public void setCommandArguments() {
        commandArguments = new String[2];
        commandArguments[0]="find";
        commandArguments[1]="--name=somename";
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionIfConfigIsNull() throws IllegalAccessException, InstantiationException, IOException, SAXException, ParserConfigurationException, TransformerException {
        setCommandDefinition();
        setCommandArguments();
        commandsService.execute(config,commandDefinition,commandArguments);
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionIfArgsIsNull() throws IllegalAccessException, InstantiationException, IOException, SAXException, ParserConfigurationException, TransformerException {
        setCommandDefinition();
        setConfig();
        commandsService.execute(config,commandDefinition,commandArguments);
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionIfCommandDefinitionIsNull() throws IllegalAccessException, InstantiationException, IOException, SAXException, ParserConfigurationException, TransformerException {
        setCommandDefinition();
        setCommandArguments();
        commandsService.execute(config,commandDefinition,commandArguments);
    }
}