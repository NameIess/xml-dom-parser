package by.xmlparser.service;

import by.xmlparser.entity.Node;

public class InnerTagCreator implements Command {

    @Override
    public Node create(Node parent, String tagName, String attributes, String body) {
        if (isParentExists(parent)) {
            Node child = new Node();
            child.setTag(tagName);
            child.setAttribute(attributes);
            child.setBody(body);
            parent.getChildEntities().add(child);
            return parent;
        } else {
            parent = new Node();
            parent.setTag(tagName);
            parent.setAttribute(attributes);
            parent.setBody(body);
            return parent;
        }
    }

    private boolean isParentExists(Node parent) {
        return parent != null;
    }
}
