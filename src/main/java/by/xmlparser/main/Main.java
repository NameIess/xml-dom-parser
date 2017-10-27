package by.xmlparser.main;

import by.xmlparser.entity.Node;
import by.xmlparser.service.NodeService;
import by.xmlparser.service.ServiceFactory;
import by.xmlparser.service.exception.ServiceException;

public class Main {
    public static void main(String[] args) throws ServiceException {
        ServiceFactory factory = ServiceFactory.getInstance();
        NodeService service = factory.getNodeService();

        try {

            Node node1 = service.parseXMLFile("task02.xml");

            System.out.println(PrintDOMStructure.print(node1));

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
