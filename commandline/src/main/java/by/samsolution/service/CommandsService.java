package by.samsolution.service;

import by.samsolution.commands.definition.CommandDefinition;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by QuantumCat on 22.06.2017.
 */



public interface CommandsService {
    /**
     *
     * @param config
     * @param commandDefinition
     * @param commandArguments
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws TransformerException
     */
    void execute(Map<String, String> config, CommandDefinition commandDefinition,
                 String[] commandArguments) throws InstantiationException, IllegalAccessException, ParserConfigurationException, SAXException, IOException, TransformerException;
}
