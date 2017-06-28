package by.samsolution.parsing;

import by.samsolution.commands.definition.CommandDefinition;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by QuantumCat on 22.06.2017.
 */
public interface ArgumentsParsing {
    /**
     * 
     * @param commandArguments
     * @param config
     * @param commandDefinition
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    void execute(String [] commandArguments, Map<String,String> config, CommandDefinition commandDefinition) throws IllegalAccessException, InstantiationException, IOException, SAXException, ParserConfigurationException, TransformerException;
}
