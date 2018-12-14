package com.marathon.manage.utils;

import com.google.common.collect.Lists;
import com.marathon.manage.refactor.pojo.ClassifyModelCustomize;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by cui on 2018/4/29.
 */
public class MarathonModelParser {

    public static List<ClassifyModelCustomize> getClassifyModel() {
        // 获取json文件
        File file = new File("D://classifyModel.json");
        List<ClassifyModelCustomize> lstClassifyModel = Lists.newArrayList();
        try {
            String json = FileUtils.readFileToString(file,"UTF-8");
            System.out.println(json);
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(json).getAsJsonObject();
            // 将db节点下的内容转为JsonArray
            JsonArray jsonArray = jsonObject.getAsJsonArray("classifyModel");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonElement el = jsonArray.get(i);
                // 映射为类实例
                ClassifyModelCustomize data = gson.fromJson(el, ClassifyModelCustomize.class);
                lstClassifyModel.add(data);
            }
        } catch (IOException e) {

        }
        return lstClassifyModel;
    }
}
