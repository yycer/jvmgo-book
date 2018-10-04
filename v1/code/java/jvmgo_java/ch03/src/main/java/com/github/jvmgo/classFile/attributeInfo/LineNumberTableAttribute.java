package com.github.jvmgo.classFile.attributeInfo;

import com.github.jvmgo.classFile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 21:57
 */
public class LineNumberTableAttribute implements AttributeInfo {


    private LineNumberTableEntry[] lineNumberTable;

    @Override
    public AttributeInfo readInfo(ClassReader reader) {
        int length = reader.nextU2ToInt();


        lineNumberTable = new LineNumberTableEntry[length];

        for (int i=0;i<length;i++){
            lineNumberTable[i]=new LineNumberTableEntry(reader);
        }
        return this;
    }

    private class LineNumberTableEntry {
        private final int startPc;
        private final int lineNumber;

        public LineNumberTableEntry(ClassReader reader) {
            startPc=reader.nextU2ToInt();
            lineNumber=reader.nextU2ToInt();
        }
    }
}
