package com.eminpolat.app;

import java.util.ArrayList;

class Application {
    public static void run(String [] args)
    {
        var xmlBuilder = new XMLElement.Builder();

        var xmlElement = xmlBuilder.setTag("meaning").setValue("An object..").addAttribute("order", "2").build();

        System.out.println(xmlElement.getTag());
        //...
    }
}

class XMLElement {
    private String m_tag;
    private final ArrayList<String> m_attributes;
    private String m_value;

    public static class Builder {
        private final XMLElement m_xmlElement = new XMLElement("", "", new ArrayList<>());

        public Builder setTag(String tag)
        {
            m_xmlElement.m_tag = tag;

            return this;
        }

        public Builder setValue(String value)
        {
            m_xmlElement.m_value = value;

            return this;
        }

        public Builder setValue(XMLElement xmlElement)
        {
            //...

            return this;
        }

        public Builder addAttribute(String name, String value)
        {
            m_xmlElement.m_attributes.add(String.format("\"%s\"=\"%s\"", name, value));

            return this;
        }
        public XMLElement build()
        {
            return m_xmlElement;
        }
    }

    private XMLElement(String tag, String value, ArrayList<String> attributes)
    {
        m_tag = tag;
        m_attributes = attributes;
        m_value = value;
    }

    public String getTag()
    {
        return m_tag;
    }

    public ArrayList<String> getAttributes()
    {
        return m_attributes;
    }

    public String getValue()
    {
        return m_value;
    }
}