package com.xiangxiang.yuoj.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件上传业务类型枚举
 */
public enum JudgeInfoMessageEnum {


    ACCEPTED("成功","Accepted"),

    WRONG_ANSWER("答案错误","Wrong Answer"),

    COMPILE_ERROR("编译错误","Compile Error"),

    MEMORY_LIMIT_EXCEEDED("内存溢出","Memory Limit Exceeded"),

    TIME_LIMIT_EXCEEDED("超时","Time Limit Exceeded"),

    PRESENTATION_ERROR("展示错误"," Presentation Error"),

    OUTPUT_LIMIT_EXCEEDED("输出溢出","Output Limit Exceeded"),
    DANGEROUS_OPERATION("输出溢出","Dangerous Operation"),
    RUNTIME_ERROR("输出溢出","Runtime Error"),
    SYSTEM_ERROR("输出溢出","System Error");

    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
