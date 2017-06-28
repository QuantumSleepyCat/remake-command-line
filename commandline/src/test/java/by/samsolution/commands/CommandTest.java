package by.samsolution.commands;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by QuantumCat on 23.06.2017.
 */
public class CommandTest {

    private Command command=new Command() {
        public void execute(Map<String, String> commandArgumentsMap, String[] commandAguments) {
            System.out.println(commandAguments[0]);
            System.out.println(commandArgumentsMap.containsKey("name"));
        }
    };
    private String[] argumentsCommand;
    private Map<String, String> commandArgumentsMap;


    @Before
    public void setUp() throws Exception {
        argumentsCommand = new String[1];
        argumentsCommand[0]="help";
    }

    public void setCommandArgumentsMap()
    {
        commandArgumentsMap = new HashMap<String, String>();
        commandArgumentsMap.put("name","test");
    }

    @Test(expected = NullPointerException.class)
    public void isItNullPointerExceptionIfcommandArgumentsMapIsNull() throws SAXException, ParserConfigurationException, IOException, TransformerException {
        command.execute(null,argumentsCommand);
    }

    @Test(expected = NullPointerException.class)
    public void isItNullPointerExceptionIfargumentsCommandIsNull() throws SAXException, ParserConfigurationException, IOException, TransformerException {
        setCommandArgumentsMap();
        command.execute(commandArgumentsMap,null);
    }
}