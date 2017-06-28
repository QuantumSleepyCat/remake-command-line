package by.samsolution.service;

import by.samsolution.checker.Checker;
import by.samsolution.commands.definition.CommandDefinition;
import by.samsolution.parsing.ArgumentsParsing;
import by.samsolution.parsing.ArgumentsParsingImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by QuantumCat on 22.06.2017.
 */
public class CommandsServiceImpl implements CommandsService {
    public void execute(Map<String, String> config, CommandDefinition commandDefinition, String[] commandArguments) throws InstantiationException, IllegalAccessException, ParserConfigurationException, SAXException, IOException, TransformerException {
        if(new Checker().execute(commandArguments,commandDefinition.getParams()))
        {
            ArgumentsParsing argumentsParsing = new ArgumentsParsingImpl();
            argumentsParsing.execute(commandArguments,config,commandDefinition);
        }
        else
        {
            throw new RuntimeException("Параметры введены неверно");
        }
    }
}
