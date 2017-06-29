package by.samsolution.commands;

import by.samsolution.commands.modelcommand.CountOptions;
import by.samsolution.commands.modelcommand.FindOptions;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by QuantumCat on 29.06.2017.
 */
public class CountCommand implements Command {
    public void execute(Map<String, String> commandArgumentsMap, String[] commandArguments) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        CountOptions countOptions =new CountOptions();
        countOptions .setCommandParams(commandArgumentsMap,commandArguments);
        System.out.println(countOptions .getFileStrategy().countInYear(countOptions, countOptions.getFilename(), countOptions.getDirname()));
    }
}
