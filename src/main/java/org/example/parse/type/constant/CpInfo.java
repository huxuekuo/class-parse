package org.example.parse.type.constant;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.parse.handle.ConstantInfoHandle;
import org.example.parse.handle.ConstantPoolHandle;
import org.example.parse.type.U1;

/**
 * tag值列表
 * <ul>
 *
 *     <li><p>CONSTANT_Class_info tag: 7</p></li>
 *     <li><p>CONSTANT_Fieldref_info tag: 9</p></li>
 *     <li><p>CONSTANT_Methodref_info tag: 10</p></li>
 *     <li><p>CONSTANT_InterfaceMethodref_info tag: 11</p></li>
 *     <li><p>CONSTANT_String_info tag: 8</p></li>
 *     <li><p>CONSTANT_Integer tag: 3</p></li>
 *     <li><p>CONSTANT_Float_info tag: 4</p></li>
 *     <li><p>CONSTANT_Long_info tag: 5</p></li>
 *     <li><p>CONSTANT_Double_info tag: 6</p></li>
 *     <li><p>CONSTANT_NameAndType_info tag: 12</p></li>
 *     <li><p>CONSTANT_Utf8_info tag: 1</p></li>
 *     <li><p>CONSTANT_MethodHandle_info tag: 15</p></li>
 *     <li><p>CONSTANT_MethodType_info tag: 16</p></li>
 *     <li><p>CONSTANT_InvokeDynamic_info tag: 18</p></li>
 *
 * </ul>
 */
@Data
@Slf4j
public abstract class CpInfo implements ConstantInfoHandle {

    private U1 tag;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     */
//    private U1[] info;
    public CpInfo(U1 tag) {
        this.tag = tag;
    }

    public String toString() {
        return "tag=" + tag.toHexString();
    }

    public static CpInfo newCpInfo(U1 tag) throws Exception {
        int tagValue = tag.toInt();
        CpInfo info;
        switch (tagValue) {
            case 1:
                info = new CONSTANT_Utf8_info(tag);
                break;
            case 3:
                info = new CONSTANT_Integer_info(tag);
                break;
            case 4:
                info = new CONSTANT_Float_info(tag);
                break;
            case 5:
                info = new CONSTANT_Long_info(tag);
                break;
            case 6:
                info = new CONSTANT_Double_info(tag);
                break;
            case 7:
                info = new CONSTANT_Class_info(tag);
                break;
            case 8:
                info = new CONSTANT_String_info(tag);
                break;
            case 9:
                info = new CONSTANT_Fieldref_info(tag);
                break;
            case 10:
                info = new CONSTANT_Methodref_info(tag);
                break;
            case 11:
                info = new CONSTANT_InterfaceMethodref_info(tag);
                break;
            case 12:
                info = new CONSTANT_NameAndType_info(tag);
                break;
            case 15:
                info = new CONSTANT_MethodHandle_info(tag);
                break;
            case 16:
                info = new CONSTANT_MethodType_info(tag);
                break;
            case 17:
                info = new CONSTANT_Dynamic_Info(tag);
                break;
            case 18:
                info = new CONSTANT_InvokeDynamic_info(tag);
                break;
            case 19:
                info = new CONSTANT_Module_Info(tag);
                break;
            case 20:
                info = new CONSTANT_Package_Info(tag);
                break;
            default:
                throw new Exception("没有找到该TAG=" + tagValue + "对应的常量类型");
        }
        return info;
    }
}
