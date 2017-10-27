package by.xmlparser.dao.impl;

import by.xmlparser.dao.NodeDAO;
import by.xmlparser.dao.exception.DAOException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class NodeDAOImpl implements NodeDAO {

    public String readFile(String fileName) throws DAOException {

        String path = this.getClass().getClassLoader().getResource(fileName).getPath();

        try {
            return Files.lines(Paths.get(path), StandardCharsets.UTF_8).map(String::trim).collect(Collectors.joining());

        } catch (IOException e) {
            throw new DAOException("IOException", e);
        }
    }
}
