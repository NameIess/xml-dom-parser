package by.xmlparser.service.impl;

import by.xmlparser.dao.DAOFactory;
import by.xmlparser.dao.NodeDAO;
import by.xmlparser.dao.exception.DAOException;
import by.xmlparser.entity.Node;
import by.xmlparser.service.NodeManager;
import by.xmlparser.service.NodeService;
import by.xmlparser.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NodeServiceImpl implements NodeService {

    private static final String XML_WITH_PROLOG = "^(<\\?.*\\?>)<([a-z-]+)([^>]+)*(?:>(.*)</(\\2)>|\\s*/>)(<!--.*-->)$";
    private static final String XML_COMMENT = "(<!--.*-->)";
    private static final String XML_TAG = "^<([a-z-]+)([^>]+)*(?:>(.*)</(\\1)>|\\s*/>)$";
    private static final Pattern prologPattern = Pattern.compile(XML_WITH_PROLOG);
    private static final Pattern commentPattern = Pattern.compile(XML_COMMENT);
    private static final Pattern tagPattern = Pattern.compile(XML_TAG);


    private DAOFactory factory = DAOFactory.getInstance();
    private NodeDAO nodeDAO = factory.getNodeDao();
    private NodeManager nodeManager = NodeManager.getNodeManager();


    public Node parseXMLFile(String filename) throws ServiceException {
        Node node = null;

        try {
            String xml = eraseInvalidData(nodeDAO.readFile(filename));
            return createDOM(node, xml, tagPattern, commentPattern, new StringBuilder());

        } catch (DAOException e) {
            throw new ServiceException("Service Exception", e);
        }
    }

    private String eraseInvalidData(String file) {
        Matcher prologMatch = prologPattern.matcher(file);
        StringBuilder validFile = new StringBuilder();

        if (prologMatch.matches()) {
            validFile.append(file.replace(prologMatch.group(1), ""));
        } else {
            validFile.append(file);
        }

        return validFile.toString();
    }

    public Node createDOM(Node currentRoot, String xml, Pattern p, Pattern pCom, StringBuilder sb) {
        Matcher tag;
        Matcher comment;

        for (int i = 0; i < xml.length(); i++) {
            sb.append(xml.charAt(i));
            tag = p.matcher(sb);
            comment = pCom.matcher(sb);

            if (comment.matches()) {
                sb.delete(0, sb.length());
                continue;
            }

            if (tag.matches() && isNestingCorrect(tag.group(3), tag.group(1))) {
                if (tag.group(3) != null && tag.group(3).contains("<") && tag.group(1).equals(tag.group(4))) {
                    boolean isParent = true;
                    currentRoot = nodeManager.getCommand(isParent).create(currentRoot, tag.group(1), tag.group(2), tag.group(3));

                    createDOM(currentRoot, tag.group(3), p, pCom, sb.delete(0, sb.length()));

                } else {
                    boolean isParent = false;
                    currentRoot = nodeManager.getCommand(isParent).create(currentRoot, tag.group(1), tag.group(2), tag.group(3));
                }

                sb.delete(0, sb.length());
            }
        }

        return currentRoot;
    }


    private boolean isNestingCorrect(String tagBody, String tagName) {
        final String ERASE_SINGLE_TAG = "<.+/";

        if (tagBody != null) {
            StringBuilder innerTags = new StringBuilder();
            for (String s : tagBody.split(">")) {
                innerTags.append(s.replaceAll(ERASE_SINGLE_TAG, ""));
            }

            return StringUtils.countMatches(innerTags, "<" + tagName) == StringUtils.countMatches(innerTags, "</" + tagName);
        } else {
            return true;
        }
    }

}
