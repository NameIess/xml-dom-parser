package by.xmlparser.service;

import by.xmlparser.service.impl.NodeServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final NodeService nodeService = new NodeServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public NodeService getNodeService() {
        return nodeService;
    }

}
