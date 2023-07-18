package org.example.parse.type;

public enum ByteCodeEnum {


    ACONST_NULL("0x01", "aconst_null", "null值入栈", 0),
    ICONST_M1("0x02", "iconst_m1", "-1(int)值入栈.", 0),
    ICONST_0("0x03", "iconst_m1", "0(int)值入栈。", 0),
    ICONST_1("0x04", "iconst_1", "1(int)  值入栈。", 0),
    ICONST_2("0x05", "iconst_2", "2(int)  值入栈。", 0),
    ICONST_3("0x06", "iconst_3", "3(int)  值入栈。", 0),
    ICONST_4("0x07", "iconst_4", "4(int)  值入栈。", 0),
    ICONST_5("0x08", "iconst_5", "5(int)  值入栈。", 0),
    LCONST_0("0x09", "lconst_0", "0(long)  值入栈。", 0),
    LCONST_1("0x0a", "lconst_1", "1(long)  值入栈。", 0),
    FCONST_0("0x0b", "fconst_0", "0(float)  值入栈。", 0),
    FCONST_1("0x0c", "fconst_1", "1(float)  值入栈。", 0),
    FCONST_2("0x0d", "fconst_2", "2(float)  值入栈。", 0),
    DCONST_0("0x0e", "dconst_0", "0(double)  值入栈。", 0),
    DCONST_1("0x0f", "dconst_1", "1(double)  值入栈。", 0),
    BIPUSH("0x10", "bipush", "int  值带符号扩展成值入栈。", 2),
    SIPUSH("0x11", "sipush", " int  值带符号扩展成值入栈。", 2),
    LDC("0x12", "ldc", "常量池中的常量值（int, float, string reference, object reference）入栈。", 1),
    LDC_W("0x13", "ldc_w", "常量池中常量（int, float, string reference, object reference）入栈。", 2),
    LDC2_W("0x14", "ldc2_w", "常量池中常量（long, double）入栈。", 2),
    ALOAD("0x19", "(wide)aload", "从局部变量indexbyte中装载引用类型值入栈。", 1),
    ALOAD_0("0x2a", "aload_0", "0  从局部变量中装载引用类型值入栈。", 0),
    ALOAD_1("0x2b", "aload_1", "1  从局部变量中装载引用类型值入栈。", 0),
    ALOAD_2("0x2c", "aload_2", "2  从局部变量中装载引用类型值入栈。", 0),
    ALOAD_3("0x2d", "aload_3", "3  从局部变量中装载引用类型值入栈。", 0),
    ILOAD("0x15", "iload", "从局部变量中indexbyte装载int类型值入栈。", 1),
    ILOAD_0("0x1a", "iload_0", "从局部变量0中装载int类型值入栈。", 0),
    ILOAD_1("0x1b", "iload_1", "从局部变量1中装载int类型值入栈。", 0),
    ILOAD_2("0x1c", "iload_2", "从局部变量2中装载int类型值入栈。", 0),
    ILOAD_3("0x1d", "iload_3", "从局部变量3中装载int类型值入栈。", 0),
    LLOAD("0x16", "lload", " 从局部变量indexbyte中装载类long型值入栈。", 1),
    LLOAD_0("0x1e", "lload_0", "从局部变量0中装载int类型值入栈。", 0),
    LLOAD_1("0x1f", "lload_1", "从局部变量1中装载int类型值入栈。", 0),
    LLOAD_2("0x20", "lload_2", "从局部变量2中装载int类型值入栈。", 0),
    LLOAD_3("0x21", "lload_3", "从局部变量3中装载int类型值入栈。", 0),
    FLOAD("0x17", "fload", " 从局部变量indexbyte中装载float类型值入栈。", 1),
    FLOAD_0("0x22", "fload_0", "从局部变量0中装载float类型值入栈。", 0),
    FLOAD_1("0x23", "fload_1", "从局部变量1中装载float类型值入栈。", 0),
    FLOAD_2("0x24", "fload_2", "从局部变量2中装载float类型值入栈。", 0),
    FLOAD_3("0x25", "fload_3", "从局部变量3中装载float类型值入栈。", 0),
    DLOAD("0x18", "dload", "从局部变量indexbyte中装载double类型值入栈。", 1),
    DLOAD_0("0x26", "dload_0", "从局部变量0中装载double类型值入栈。", 0),
    DLOAD_1("0x27", "dload_1", "从局部变量1中装载double类型值入栈。", 0),
    DLOAD_2("0x28", "dload_2", "从局部变量2中装载double类型值入栈。", 0),
    DLOAD_3("0x29", "dload_3", "从局部变量3中装载double类型值入栈。", 0),
    AALOAD("0x32", "aaload", "从引用类型数组中装载指定项的值。", 0),
    IALOAD("0x2e", "iaload", "从int类型数组中装载指定项的值。", 0),
    LALOAD("0x2f", "laload", "从long类型数组中装载指定项的值。", 0),
    FALOAD("0x30", "faload", "从float类型数组中装载指定项的值。", 0),
    DALOAD("0x31", "daload", "从double类型数组中装载指定项的值。", 0),
    BALOAD("0x33", "baload", "    从boolean类型数组或byte类型数组中装载指定项的值（先转换为int类型值，后压栈）。", 0),
    CALOAD("0x34", "caload", "从char类型数组中装载指定项的值（先转换为int类型值，后压栈）。", 0),
    SALOAD("0x35", "saload", "从short类型数组中装载指定项的值（先转换为int类型值，后压栈）。", 0),
    ASTORE("0x3a", "(wide)astore", "将栈顶引用类型值保存到局部变量indexbyte中。", 0),
    ASTROE_0("0x4b", "astroe_0", "将栈顶引用类型值保存到局部变量0  中。", 0),
    ASTORE_1("0x4c", "astore_1", "将栈顶引用类型值保存到局部变量1  中。", 0),
    ASTORE_2("0x4d", "astore_2", "将栈顶引用类型值保存到局部变量2  中。", 0),
    ASTORE_3("0x4e", "astore_3", "将栈顶引用类型值保存到局部变量3  中。", 0),
    ISTORE("0x36", "(wide)istore", "将栈顶int类型值保存到局部变量indexbyte中。", 1),
    ISTORE_0("0x3b", "istore_0", "将栈顶int类型值保存到局部变量0中。", 0),
    ISTORE_1("0x3c", "istore_1", "将栈顶int类型值保存到局部变量1中。", 0),
    ISTORE_2("0x3d", "istore_2", "将栈顶int类型值保存到局部变量2中。", 0),
    ISTORE_3("0x3e", "istore_3", "将栈顶int类型值保存到局部变量3中。", 0),
    LSTORE("0x37", "(wide)lstore", "将栈顶long类型值保存到局部变量indexbyte中。", 1),
    LSTORE_0("0x3f", "lstore_0", "将栈顶long类型值保存到局部变量0  中。", 0),
    LSTORE_1("0x40", "lstore_1", "将栈顶long类型值保存到局部变量1  中。", 0),
    LSTORE_2("0x41", "lstore_2", "将栈顶long类型值保存到局部变量2  中。", 0),
    LSTROE_3("0x42", "lstroe_3", "将栈顶long类型值保存到局部变量3  中。", 0),
    FSTORE("0x38", "(wide)fstore", "将栈顶float类型值保存到局部变量indexbyte中。", 1),
    FSTORE_0("0x43", "fstore_0", "将栈顶float类型值保存到局部变量0中。", 0),
    FSTORE_1("0x44", "fstore_1", "将栈顶float类型值保存到局部变量1中。", 0),
    FSTORE_2("0x45", "fstore_2", "将栈顶float类型值保存到局部变量2中。", 0),
    FSTORE_3("0x46", "fstore_3", "将栈顶float类型值保存到局部变量3中。", 0),
    DSTORE("0x39", "(wide)dstore", "将栈顶double类型值保存到局部变量indexbyte中。", 1),
    DSTORE_0("0x47", "dstore_0", "将栈顶double类型值保存到局部变量0中。", 0),
    DSTORE_1("0x48", "dstore_1", "将栈顶double类型值保存到局部变量1中。", 0),
    DSTORE_2("0x49", "dstore_2", "将栈顶double类型值保存到局部变量2中。", 0),
    DSTORE_3("0x4a", "dstore_3", "将栈顶double类型值保存到局部变量3中。", 0),
    AASTORE("0x53", "aastore", "将栈顶引用类型值保存到指定引用类型数组的指定项。", 0),
    IASTORE("0x4f", "iastore", "将栈顶int类型值保存到指定int类型数组的指定项。", 0),
    LASTORE("0x50", "lastore", "将栈顶long类型值保存到指定long类型数组的指定项。", 0),
    FASTORE("0x51", "fastore", "将栈顶float类型值保存到指定float类型数组的指定项。", 0),
    DASTORE("0x52", "dastore", "将栈顶double类型值保存到指定double类型数组的指定项。", 0),
    BASTROE("0x54", "bastroe", "     将栈顶boolean类型值或byte类型值保存到指定boolean类型数组或byte类型数组的指定项。", 0),
    CASTORE("0x55", "castore", "将栈顶char类型值保存到指定char类型数组的指定项。", 0),
    SASTORE("0x56", "sastore", "将栈顶short类型值保存到指定short类型数组的指定项。", 0),
    WIDE("0xc4", "wide", "  使用附加字节扩展局部变量索引（iinc指令特殊）。", 0),
    NOP("0x00", "nop", "空操作。", 0),
    POP("0x57", "pop", "从栈顶弹出一个字长的数据。", 0),
    POP2("0x58", "pop2", "从栈顶弹出两个字长的数据。", 0),
    DUP("0x59", "dup", "复制栈顶一个字长的数据，将复制后的数据压栈。", 0),
    DUP_X1("0x5a", "dup_x1", "复制栈顶一个字长的数据，弹出栈顶两个字长数据，先将复制后的数据压栈，再将弹出的两个字长数据压栈。", 0),
    DUP_X2("0x5b", "dup_x2", "复制栈顶一个字长的数据，弹出栈顶三个字长的数据，将复制后的数据压栈，再将弹出的三个字长的数据压栈。", 0),
    DUP2("0x5c", "dup2", "复制栈顶两个字长的数据，将复制后的两个字长的数据压栈。", 0),
    DUP2_X1("0x5d", "dup2_x1", "复制栈顶两个字长的数据，弹出栈顶三个字长的数据，将复制后的两个字长的数据压栈，再将弹出的三个字长的数据压栈。", 0),
    DUP2_X2("0x5e", "dup2_x2", "复制栈顶两个字长的数据，弹出栈顶四个字长的数据，将复制后的两个字长的数据压栈，再将弹出的四个字长的数据压栈。", 0),
    SWAP("0x5f", "swap", "交换栈顶两个字长的数据的位置。指令中没有提供以两个字长为单位的交换指令。", 0),
    I2F("0x86", "i2f", "将栈顶int类型值转换为float类型值。", 0),
    I2L("0x85", "i2l", "将栈顶int类型值转换为long类型值。", 0),
    I2D("0x87", "i2d", "将栈顶int类型值转换为double类型值。", 0),
    F2I("0x8b", "f2i", "将栈顶float类型值转换为int类型值。", 0),
    F2L("0x8c", "f2l", "将栈顶float类型值转换为long类型值。", 0),
    F2D("0x8d", "f2d", "将栈顶float类型值转换为double类型值。", 0),
    L2I("0x88", "l2i", "将栈顶long类型值转换为int类型值。", 0),
    L2F("0x89", "l2f", "将栈顶long类型值转换为float类型值。", 0),
    L2D("0x8a", "l2d", "将栈顶long类型值转换double类型值。", 0),
    D2I("0x8e", "d2i", "将栈顶double类型值转换为int类型值。", 0),
    D2F("0x90", "d2f", "将栈顶double类型值转换为float类型值。", 0),
    D2L("0x8f", "d2l", "将栈顶double类型值转换为long类型值。", 0),
    I2B("0x91", "i2b", "将栈顶int类型值截断成byte类型，后带符号扩展成int类型值入栈。", 0),
    I2C("0x92", "i2c", "将栈顶int类型值截断成char类型值，后带符号扩展成int类型值入栈。", 0),
    I2S("0x93", "i2s", "将栈顶int类型值截断成short类型值，后带符号扩展成 int类型值入栈。", 0),
    IADD("0x60", "iadd", "将栈顶两int类型数相加，结果入栈。", 0),
    ISUB("0x64", "isub", "将栈顶两int类型数相减，结果入栈。", 0),
    IMUL("0x68", "imul", "将栈顶两int类型数相乘，结果入栈。", 0),
    IDIV("0x6c", "idiv", "将栈顶两int类型数相除，结果入栈。", 0),
    IREM("0x70", "irem", "将栈顶两int类型数取模，结果入栈。", 0),
    INEG("0x74", "ineg", "将栈顶类int型值取负，结果入栈。", 0),
    LADD("0x61", "ladd", "将栈顶两long类型数相加，结果入栈。", 0),
    LSUB("0x65", "lsub", "将栈顶两long类型数相减，结果入栈。", 0),
    LMUL("0x69", "lmul", "将栈顶两long类型数相乘，结果入栈。", 0),
    LDIV("0x6d", "ldiv", "将栈顶两long类型数相除，结果入栈。", 0),
    LREM("0x71", "lrem", "将栈顶两long类型数取模，结果入栈。", 0),
    LNEG("0x75", "lneg", "将栈顶类long型值取负，结果入栈。", 0),
    IINC("0x84", "(wide)iinc", "将整数值constbyte加到indexbyte指定的int类型的局部变量中。", 2),
    FADD("0x62", "fadd", "将栈顶float两类型数相加，结果入栈。", 0),
    FSUB("0x66", "fsub", "将栈顶float两类型数相减，结果入栈。", 0),
    FMUL("0x6a", "fmul", "将栈顶float两类型数相乘，结果入栈。", 0),
    FDIV("0x6e", "fdiv", "将栈顶float两类型数相除，结果入栈。", 0),
    FREM("0x72", "frem", "将栈顶float两类型数取模，结果入栈。", 0),
    FNEG("0x76", "fneg", "将栈顶float类型值取反，结果入栈。", 0),
    DADD("0x63", "dadd", "将栈顶double两类型数相加，结果入栈。", 0),
    DSUB("0x67", "dsub", "将栈顶double两类型数相减，结果入栈。", 0),
    DMUL("0x6b", "dmul", "将栈顶double两类型数相乘，结果入栈。", 0),
    DDIV("0x6f", "ddiv", "将栈顶double两类型数相除，结果入栈。", 0),
    DREM("0x73", "drem", "将栈顶double两类型数取模，结果入栈。", 0),
    DNEG("0x77", "dneg", "将栈顶double类型值取负，结果入栈。", 0),
    ISHL("0x78", "ishl", "  左移int类型值。", 0),
    LSHL("0x79", "lshl", "  左移long类型值。", 0),
    ISHR("0x7a", "ishr", "  算术右移int类型值。", 0),
    LSHR("0x7b", "lshr", "  算术右移long类型值。", 0),
    IUSHR("0x7c", "iushr", "  逻辑右移int类型值。", 0),
    LUSHR("0x7d", "lushr", "  逻辑右移long类型值。", 0),
    IAND("0x73", "iand", "  对int类型按位与运算。", 0),
    LAND("0x7f", "land", "  对long类型的按位与运算。", 0),
    IOR("0x80", "ior", "  对int类型的按位或运算。", 0),
    LOR("0x81", "lor", "  对long类型的按位或运算。", 0),
    IXOR("0x82", "ixor", "  对int类型的按位异或运算。", 0),
    LXOR("0x83", "lxor", "  对long类型的按位异或运算。", 0),
    IFEQ("0x99", "ifeq", "若栈顶int类型值为0则跳转。", 2),
    IFNE("0x9a", "ifne", "若栈顶int类型值不为0则跳转。", 2),
    IFLT("0x9b", "iflt", "若栈顶int类型值小于0则跳转。", 2),
    IFLE("0x9e", "ifle", "若栈顶int类型值小于等于0则跳转。", 2),
    IFGT("0x9d", "ifgt", "若栈顶int类型值大于0则跳转。", 2),
    IFGE("0x9c", "ifge", "若栈顶int类型值大于等于0则跳转。", 2),
    IF_ICMPEQ("0x9f", "if_icmpeq", "若栈顶两int类型值相等则跳转。", 2),
    IF_ICMPNE("0xa0", "if_icmpne", "若栈顶两int类型值不相等则跳转。", 2),
    IF_ICMPLT("0xa1", "if_icmplt", "若栈顶两int类型值前小于后则跳转。", 2),
    IF_ICMPLE("0xa4", "if_icmple", "若栈顶两int类型值前小于等于后则跳转。", 2),
    IF_ICMPGT("0xa3", "if_icmpgt", "若栈顶两int类型值前大于后则跳转。", 2),
    IF_ICMPGE("0xa2", "if_icmpge", "若栈顶两int类型值前大于等于后则跳转。", 2),
    IFNULL("0xc6", "ifnull", "若栈顶引用值为null则跳转。", 2),
    IFNONNULL("0xc7", "ifnonnull", "若栈顶引用值不为null则跳转。", 2),
    IF_ACMPEQ("0xa5", "if_acmpeq", "若栈顶两引用类型值相等则跳转。", 2),
    IF_ACMPNE("0xa6", "if_acmpne", "若栈顶两引用类型值不相等则跳转。", 2),
    LCMP("0x94", "lcmp", "比较栈顶两long类型值，前者大，1入栈；相等，0入栈；后者大，-1入栈。", 0),
    FCMPL("0x95", "fcmpl", "比较栈顶两float类型值，前者大，1入栈；相等，0入栈；后者大，-1入栈；有存在NaN，-1入栈。", 0),
    FCMPG("0x96", "fcmpg", "比较栈顶两float类型值，前者大，1入栈；相等，0入栈；后者大，-1入栈；有存在NaN，-1入栈。", 0),
    DCMPL("0x97", "dcmpl", "比较栈顶两double类型值，前者大，1入栈；相等，0入栈；后者大，-1入栈；有存在NaN，-1入栈。", 0),
    DCMPG("0x98", "dcmpg", "比较栈顶两double类型值，前者大，1入栈；相等，0入栈；后者大，-1入栈；有存在NaN，-1入栈。", 0),
    GOTO("0xa7", "goto", "无条件跳转到指定位置。", 2),
    GOTO_W("0xc8", "goto_w", "无条件跳转到指定位置（宽索引）。", 4),
    TABLESWITCH("0xaa", "tableswitch", "通过索引访问跳转表，并跳转。", 14),
    LOOKUPSWITCH("0xab", "lookupswitch", "通过键值访问跳转表，并跳转。", 10),
    ATHROW("0xbf", "athrow", "抛出异常。", 0),
    JSR("0xa8", "jsr", "跳转到子例程序。", 2),
    JSR_W("0xc9", "jsr_w", "跳转到子例程序（宽索引）。", 4),
    RET("0xa9", "ret", "返回子例程序。", 1),
    NEW("0xbb", "new", "创建新的对象实例。", 2),
    CHECKCAST("0xc0", "checkcast", "类型强转。", 2),
    INSTANCEOF("0xc1", "instanceof", "判断类型。", 2),
    GETFIELD("0xb4", "getfield", "获取对象字段的值。", 2),
    PUTFIELD("0xb5", "putfield", "给对象字段赋值。", 2),
    GETSTATIC("0xb2", "getstatic", "获取静态字段的值。", 2),
    PUTSTATIC("0xb3", "putstatic", "给静态字段赋值。", 2),
    NEWARRAY("0xbc", "newarray", "创建type类型的数组。", 1),
    ANEWARRAY("0xbd", "anewarray", "创建引用类型的数组。", 2),
    ARRAYLENGTH("0xbe", "arraylength", "获取一维数组的长度。", 0),
    MULTIANEWARRAY("0xc5", "multianewarray", "创建dimension维度的数组。", 3),
    INVOKESPECIAL("0xb7", "invokespecial", "编译时方法绑定调用方法。", 2),
    INVOKEVIRTUAL("0xb6", "invokevirtual", "运行时方法绑定调用方法。", 2),
    INVOKESTATIC("0xb8", "invokestatic", "调用静态方法。", 2),
    INVOKEINTERFACE("0xb9", "invokeinterface", "调用接口方法。", 4),
    IRETURN("0xac", "ireturn", "返回int类型值。", 0),
    LRETURN("0xad", "lreturn", "返回long类型值。", 0),
    FRETURN("0xae", "freturn", "返回float类型值。", 0),
    DRETURN("0xaf", "dreturn", "返回double类型值。", 0),
    ARETURN("0xb0", "areturn", "返回引用类型值。", 0),
    RETURN("0xb1", "return", "void  函数返回。", 0),
    MONITORENTER("0xc2", "monitorenter", "进入并获得对象监视器。", 0),
    MONITOREXIT("0xc3", "monitorexit", "释放并退出对象监视器。", 0);
    private final String byteCode;

    private final String opCode;

    private final String desc;
    private final Integer paramNumber;


    public static ByteCodeEnum byByteCode(String byteCode) {
        for (ByteCodeEnum value : values()) {
            if (value.byteCode.equalsIgnoreCase(byteCode)) {
                return value;
            }
        }
        return null;
    }


    ByteCodeEnum(String byteCode, String opCode, String desc, Integer paramNumber) {
        this.byteCode = byteCode;
        this.opCode = opCode;
        this.desc = desc;
        this.paramNumber = paramNumber;
    }

    public String getDesc() {
        return desc;
    }

    public String getByteCode() {
        return byteCode;
    }

    public String getOpCode() {
        return opCode;
    }

    public Integer getParamNumber() {
        return paramNumber;
    }
}
