package com.planner.services;

// Packages import

import com.planner.controllers.*;
import com.planner.interfaces.*;
import com.planner.models.*;

// Java classes import
import java.io.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;

public class Explorer implements ExplorerInterface {

    @Override
    public void parserReader () {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(com.planner.Constants.FILE_PATH);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("task");
            System.out.println("************************* \n All tasks:  \n");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\n Task №: " + (temp + 1));

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Description: " + eElement.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("Date&Time: " + eElement.getElementsByTagName("dateTime").item(0).getTextContent());
                    System.out.println("Conacts: " + eElement.getElementsByTagName("conacts").item(0).getTextContent());
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void parserWriter() {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(com.planner.Constants.FILE_PATH);

            /*
            Node cars = doc.getFirstChild();
            Node supercar = doc.getElementsByTagName("supercars").item(0);

            // update supercar attribute
            NamedNodeMap attr = supercar.getAttributes();
            Node nodeAttr = attr.getNamedItem("company");
            nodeAttr.setTextContent("Lamborigini");

            // loop the supercar child node
            NodeList list = supercar.getChildNodes();

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    if ("carname".equals(eElement.getNodeName())) {
                        if("Ferrari 101".equals(eElement.getTextContent())) {
                            eElement.setTextContent("Lamborigini 001");
                        }
                        if("Ferrari 202".equals(eElement.getTextContent()))
                            eElement.setTextContent("Lamborigini 002");
                    }
                }
            }
            NodeList childNodes = cars.getChildNodes();

            for(int count = 0; count < childNodes.getLength(); count++) {
                Node node = childNodes.item(count);

                if("luxurycars".equals(node.getNodeName()))
                    cars.removeChild(node);
            }

            // write the content on console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            System.out.println("-----------Modified File-----------");
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
      }
    }