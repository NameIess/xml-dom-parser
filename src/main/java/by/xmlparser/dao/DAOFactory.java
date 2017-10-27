package by.xmlparser.dao;

import by.xmlparser.dao.impl.NodeDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final NodeDAO nodeDao = new NodeDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public NodeDAO getNodeDao() {
        return nodeDao;
    }
}

