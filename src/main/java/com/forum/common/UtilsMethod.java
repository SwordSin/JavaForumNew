package com.forum.common;

import org.springframework.beans.factory.annotation.Autowired;

public class UtilsMethod {
    // 查看错误
    @Autowired
    private static PropertiesList propertiesList;

    /**
     * 根据错误信息 和 错误信息中的索引名,判断在存储数据库时出现的什么错误
     * @param errorMsg 错误信息
     * @param indexName 索引名字
     * @return
     */
    public static Boolean errType(String errorMsg, String indexName) {
        Boolean msgStatus = errorMsg.contains(indexName);
        if (msgStatus) {
            if (indexName.equals(propertiesList.getUqEmail())) {
                throw new BusisnessException(20005, "邮箱重复");
            } else if(indexName.equals(propertiesList.getUqUsername())) {
                throw new BusisnessException(20005, "用户名重复");
            }
        }
        return msgStatus;
    }
}
