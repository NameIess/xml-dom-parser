package by.xmlparser.service;

import by.xmlparser.entity.Node;

public interface Command {

    Node create(Node parent, String tagName, String attributes, String body);
}
