package by.xmlparser.entity;

import java.io.Serializable;
import java.util.List;

public class Node implements Serializable {

    private String tag;
    private String attribute;
    private String body;
    private List<Node> childEntities;

    public Node() {

    }

    public Node(String tag, String attribute, String body, List<Node> childEntities) {
        this.tag = tag;
        this.attribute = attribute;
        this.body = body;
        this.childEntities = childEntities;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Node> getChildEntities() {
        return childEntities;
    }

    public void setChildEntities(List<Node> childEntities) {
        this.childEntities = childEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (getTag() != null ? !getTag().equals(node.getTag()) : node.getTag() != null) return false;
        if (getAttribute() != null ? !getAttribute().equals(node.getAttribute()) : node.getAttribute() != null)
            return false;
        if (getBody() != null ? !getBody().equals(node.getBody()) : node.getBody() != null) return false;
        return getChildEntities() != null ? getChildEntities().equals(node.getChildEntities()) : node.getChildEntities() == null;
    }

    @Override
    public int hashCode() {
        int result = getTag() != null ? getTag().hashCode() : 0;
        result = 31 * result + (getAttribute() != null ? getAttribute().hashCode() : 0);
        result = 31 * result + (getBody() != null ? getBody().hashCode() : 0);
        result = 31 * result + (getChildEntities() != null ? getChildEntities().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("tag='").append(tag).append('\'');
        sb.append(", attribute='").append(attribute).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", childEntities=").append(childEntities);
        sb.append('}');
        sb.append("\n\t");
        return sb.toString();
    }


}
