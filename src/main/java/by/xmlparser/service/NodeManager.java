package by.xmlparser.service;

import java.util.HashMap;
import java.util.Map;

public class NodeManager {

    private static NodeManager nodeManager;

    private Map<Boolean, Command> map = new HashMap<>();

    private NodeManager() {
        map.put(false, new InnerTagCreator());
        map.put(true, new ParentTagCreator());
    }

    public static NodeManager getNodeManager() {
        if (nodeManager == null) {
            nodeManager = new NodeManager();
        }

        return nodeManager;
    }

    public Command getCommand(Boolean isParent) {
        Command command;
        command = map.get(isParent);
        return command;
    }
}
