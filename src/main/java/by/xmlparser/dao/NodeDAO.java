package by.xmlparser.dao;

import by.xmlparser.dao.exception.DAOException;

public interface NodeDAO {

    String readFile(String path) throws DAOException;

}
