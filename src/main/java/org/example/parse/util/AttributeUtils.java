package org.example.parse.util;

import org.example.parse.type.AttributeInfo;
import org.example.parse.type.ConstantValue_attribute;
import org.example.parse.type.U2;

public class AttributeUtils {

    public static ConstantValue_attribute processingConstantValue(AttributeInfo info) {
        ConstantValue_attribute attribute = new ConstantValue_attribute();
        attribute.setAttribute_name_index(info.getAttribute_name_index());
        attribute.setAttribute_length(info.getAttribute_length());
        attribute.setConstantValue_index(new U2(info.getInfo()[0], info.getInfo()[1]));
        return attribute;
    }
}
