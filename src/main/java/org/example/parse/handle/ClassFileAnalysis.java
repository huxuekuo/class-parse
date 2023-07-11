package org.example.parse.handle;

import lombok.extern.slf4j.Slf4j;
import org.example.parse.type.ClassFile;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class 文件解析器
 */
@Slf4j
public class ClassFileAnalysis {

    private final static List<BaseByteCodeHandler> handlers = new ArrayList<>();

    /**
     * 责任链
     */
    static {
        handlers.add(new MagicHandler());
        handlers.add(new VersionHandler());
        handlers.add(new ConstantPoolHandle());
        handlers.add(new AccessFlagsHandle());
        handlers.add(new ThisAndSuperClassHandle());
        handlers.add(new InterfaceHandle());
        handlers.add(new FieldHandle());
        handlers.add(new MethodHandle());
        handlers.add(new AttributesHandle());

        // 解析排序
        handlers.sort((Comparator.comparingInt(BaseByteCodeHandler::order)));
    }

    public static ClassFile analysis(ByteBuffer codeBuf) throws Exception {
        codeBuf.position(0);
        ClassFile classFile = new ClassFile();
        for (BaseByteCodeHandler handler : handlers) {
            handler.read(codeBuf, classFile);
        }
        log.debug("class文件结构解析完成.解析是否正常(剩余未解析字节数:{})", codeBuf.remaining());
        return classFile;
    }

}
