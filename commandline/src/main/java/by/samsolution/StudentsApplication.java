package by.samsolution;

import by.samsolution.commands.definition.CommandDefinition;
import by.samsolution.service.CommandsService;
import by.samsolution.service.CommandsServiceImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by QuantumCat on 20.06.2017.
 */
public class StudentsApplication {

    private final Map<String, String> config;
    private final List<CommandDefinition> commandDefinitionList;
    private Map<String, CommandDefinition> commandDefinitionMap = new HashMap<String, CommandDefinition>();

    public StudentsApplication(Map<String, String> config,  List<CommandDefinition> commandDefinitionLis)
    {
        if(config==null || commandDefinitionLis == null || commandDefinitionMap==null)
        {
            throw new RuntimeException("Ошибка инициализации приложения");
        }
        this.config=config;
        this.commandDefinitionList=commandDefinitionLis;
    }

    private void commandDefinitionMapInit()
    {
        for(CommandDefinition commandDefin: commandDefinitionList)
        {
            commandDefinitionMap.put(commandDefin.getName(),commandDefin);
        }
    }

    public void run(String[] commandArguments)
    {
        if(commandArguments.length==0)
        {
            throw new RuntimeException("Аргументы не найдены");
        }

            commandDefinitionMapInit();
            CommandDefinition commandDefinition = commandDefinitionMap.get(commandArguments[0]);
            if(commandDefinition!=null) {
                CommandsService commandsService = new CommandsServiceImpl();
                try {
                    commandsService.execute(config,commandDefinition,commandArguments);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                throw new RuntimeException(commandArguments[0] + " не является командой");
            }
    }

}
