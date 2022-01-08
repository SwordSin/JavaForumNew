package com.forum.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UtilsMethod {
    // 查看错误
    @Autowired
    private PropertiesList propertiesList;


    /**
     * 根据错误信息 和 错误信息中的索引名,判断在存储数据库时出现的什么错误
     * @param errorMsg 错误信息
     * @param indexName 索引名字
     * @return
     */
    public Boolean errType(String errorMsg, String indexName) {

        Boolean msgStatus = errorMsg.contains(indexName);
        if (msgStatus) {
            if (indexName.equals(propertiesList.getUkEmail())) {
                throw new BusisnessException(20005, "邮箱重复");
            } else if(indexName.equals(propertiesList.getUkUsername())) {
                throw new BusisnessException(20005, "用户名重复");
            } else if (indexName.equals(propertiesList.getUkBoardName())) {
                throw new BusisnessException(20005, "板块名称重复");
            }
        }
        return msgStatus;
    }
}
