package by.samsolution.commands.definition;

import by.samsolution.commands.Command;
import by.samsolution.params.ParamDefinition;

import java.util.List;

/**
 * Created by QuantumCat on 20.06.2017.
 */
public class CommandDefinition {
    private String name;
    private Class<? extends Command> command;
    private List<ParamDefinition> params;

    public CommandDefinition(String name, Class<? extends Command> command, List<ParamDefinition> params)
    {
        this.command=command;
        this.name = name;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public Class<? extends Command> getCommand() {
        return command;
    }

    public List<ParamDefinition> getParams() {
        return params;
    }
}
