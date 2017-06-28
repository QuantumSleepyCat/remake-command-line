package by.samsolution.checker;

import by.samsolution.params.ParamDefinition;

import java.util.List;

/**
 * Created by QuantumCat on 22.06.2017.
 */
public interface CheckerCommand {
    /**
     *
     * @param argumentsCommand
     * @param paramDefinitionList
     * @throws NullPointerException
     * @return
     */
    boolean execute(String[] argumentsCommand, List<ParamDefinition> paramDefinitionList);
}
