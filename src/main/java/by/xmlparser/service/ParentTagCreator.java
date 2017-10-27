package by.xmlparser.service;

import by.xmlparser.entity.Node;

import java.util.ArrayList;

public class ParentTagCreator implements Command {

    @Override
    public Node create(Node parent, String tagName, String attributes, String body) {
        if (isParentExists(parent)) {
            parent.getChildEntities().add(new Node());
            Node e1 = parent.getChildEntities().get(parent.getChildEntities().size() - 1);
            e1.setTag(tagName);
            e1.setAttribute(attributes);
            e1.setBody("has a child");
            e1.setChildEntities(new ArrayList<>());
            return e1;

        } else {
            parent = new Node();
            parent.setTag(tagName);
            parent.setAttribute(attributes);
            parent.setBody("has a child");
            parent.setChildEntities(new ArrayList<>());
            return parent;
        }

    }

    private boolean isParentExists(Node parent) {
        return parent != null;
    }
}
