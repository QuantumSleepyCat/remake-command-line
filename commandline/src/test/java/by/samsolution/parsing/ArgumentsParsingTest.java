package by.samsolution.parsing;

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
public class ArgumentsParsingTest {

    private String [] commandArguments;
    private Map<String,String> config;
    private CommandDefinition commandDefinition;
    private ArgumentsParsing argumentsParsing;
    private Command command =new Command() {
        public void execute(Map<String, String> commandArgumentsMap, String[] commandAguments)  {
            System.out.println(commandAguments[0]);
            System.out.println(commandArgumentsMap.containsKey("name"));
        }
    };


    @Before
    public void initArgumentsParsing()
    {
        argumentsParsing = new ArgumentsParsingImpl();
    }

    public void setCommandArguments() {
        commandArguments=new String[1];
        commandArguments[0]="list";
    }

    public void setCommandDefinition() {
        List<ParamDefinition> paramsList = new ArrayList<ParamDefinition>();
        paramsList.add(new ParamDefinition("--filename", false));
        paramsList.add(new ParamDefinition("--dirname", false));
        commandDefinition=new CommandDefinition("list", command.getClass(), paramsList);
    }

    public void setConfig() {
        config = new HashMap<String, String>();
        config.put("filename","students.txt");
        config.put("dirname","stud");
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionIfArgsIsNull() throws IllegalAccessException, InstantiationException, ParserConfigurationException, SAXException, IOException, TransformerException {
        setCommandDefinition();
        setConfig();
        argumentsParsing.execute(commandArguments,config,commandDefinition);
    }
    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionIfConfigIsNull() throws IllegalAccessException, InstantiationException, ParserConfigurationException, SAXException, IOException, TransformerException {
        setCommandArguments();
        setCommandDefinition();
        argumentsParsing.execute(commandArguments,config,commandDefinition);
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionIfCommandDefinitionIsNull() throws IllegalAccessException, InstantiationException, ParserConfigurationException, SAXException, IOException, TransformerException {
        setCommandArguments();
        setConfig();
        argumentsParsing.execute(commandArguments,config,commandDefinition);
    }

}