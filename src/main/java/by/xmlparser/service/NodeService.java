package by.xmlparser.service;

import by.xmlparser.entity.Node;
import by.xmlparser.service.exception.ServiceException;

public interface NodeService {

    Node parseXMLFile(String filename) throws ServiceException;
}
