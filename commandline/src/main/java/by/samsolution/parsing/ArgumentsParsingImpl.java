package by.samsolution.parsing;

import by.samsolution.commands.Command;
import by.samsolution.commands.definition.CommandDefinition;
import by.samsolution.utility.AttributesPars;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by QuantumCat on 22.06.2017.
 */
public class ArgumentsParsingImpl implements ArgumentsParsing{

    private Map<String, String> commandArgumentsMap = new HashMap<String, String>();

    public void execute(String[] commandArguments, Map<String, String> config, CommandDefinition commandDefinition) throws IllegalAccessException, InstantiationException, IOException, SAXException, ParserConfigurationException, TransformerException {
        for(int i=1;i<commandArguments.length;i++)
        {
            if(commandArguments[i].contains("=")) {
                commandArgumentsMap.put(new AttributesPars().getAttrName(commandArguments[i]), new AttributesPars().getAttr(commandArguments[i]));
            }
        }
        for(String key:config.keySet())
        {
            if(commandArgumentsMap.get(key)==null)
            {
                commandArgumentsMap.put(key,config.get(key));
            }
        }
           Command command= commandDefinition.getCommand().newInstance();

           command.execute(commandArgumentsMap,commandArguments);
    }
}
