package com.forum.common;

public class UtilsMethod {
    // 查看错误

    /**
     * 根据错误信息 和 错误信息中的索引名,判断在存储数据库时出现的什么错误
     * @param errorMsg 错误信息
     * @param indexName 索引名字
     * @return
     */
    public static Boolean errType(String errorMsg, String indexName) {
        return errorMsg.contains(indexName);
    }
}
