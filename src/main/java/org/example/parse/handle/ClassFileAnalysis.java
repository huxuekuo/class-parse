package org.example.parse.handle;

import org.example.parse.type.ClassFile;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class 文件解析器
 */
public class ClassFileAnalysis {

    private final static List<BaseByteCodeHandler> handlers = new ArrayList<>();

    /**
     * 责任链
     */
    static {
        handlers.add(new MagicHandler());
        handlers.add(new VersionHandler());
        handlers.add(new ConstantPoolHandle());

        // 解析排序
        handlers.sort((Comparator.comparingInt(BaseByteCodeHandler::order)));
    }

    public static ClassFile analysis(ByteBuffer codeBuf) throws Exception {
        codeBuf.position(0);
        ClassFile classFile = new ClassFile();
        for (BaseByteCodeHandler handler : handlers) {
            handler.read(codeBuf, classFile);
        }
        return classFile;
    }

}
