package com.osama.task.command;

import com.osama.task.command.user.EmptyCommand;
import com.osama.task.utils.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

import static com.osama.task.command.ActionCommand.COMMAND_PARAMETER;
import static com.osama.task.command.ActionCommand.MESSAGE_ATTRIBUTE;
import static com.osama.task.utils.MessageManager.COMMAND_ERROR_MESSAGE_KEY;

/**
 * Factory class for creation commands.
 *
 * @author Osama Alfaqeeh
 * @see ActionCommand
 */
public class CommandFactory {

    private static final Logger LOGGER = Logger.getLogger(CommandFactory.class.getName());

    /**
     * This method define commands and return it's instance.
     *
     * @param request the HttpServletRequest request.
     * @return the defined commands.
     */
    public ActionCommand defineCommand(HttpServletRequest request){
        ActionCommand currentCommand = new EmptyCommand();

        String action = request.getParameter(COMMAND_PARAMETER);
        if (action == null || action.isEmpty()) {
            LOGGER.info(String.format("Command - %s, is empty.", action));
            return currentCommand;
        }
        try {
            String commandTypeValue = action.toUpperCase();
            CommandType currentType = CommandType.valueOf(commandTypeValue);
            currentCommand = currentType.getCurrentCommand();
        } catch (IllegalArgumentException exception) {
            LOGGER.warning(String.format("Command - %s, cause exception.", action) + exception);
            String message = String.format("%s %s", action, MessageManager.getProperty(COMMAND_ERROR_MESSAGE_KEY));
            request.setAttribute(MESSAGE_ATTRIBUTE, message);
        }
        return currentCommand;
    }
}
