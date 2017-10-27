package by.xmlparser.main;

import by.xmlparser.entity.Node;

public final class PrintDOMStructure {

    private PrintDOMStructure() {
    }

    public static StringBuilder print(Node node) {
        final StringBuilder sb = new StringBuilder();

        sb.append("Node{ tagName=\'").append(node.getTag()).append('\'');
        sb.append(", attribute='").append(node.getAttribute()).append('\'');
        sb.append(", body='").append(node.getBody()).append('\'');
        sb.append(", childEntities=").append(node.getChildEntities()).append("}");
        sb.append("\n\t");

        return sb;
    }

}
